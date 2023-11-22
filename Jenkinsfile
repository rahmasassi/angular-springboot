pipeline {
    agent any

    environment {
        SSH_USER = 'ec2-user'
        EC2_HOST = 'ec2-50-16-248-154.compute-1.amazonaws.com'
    }

    tools{
        maven 'maven-3.6'
        nodejs 'nodeJs'
    }

    stages {

        stage('Build Angular App') {
            steps {
                script {
                    echo 'Building the Angular application'
                    dir('Angular') {
                        sh 'npm install'
                        sh 'npm install -g @angular/cli'
                        sh 'ng build'
                    }
                }
            }
        }

        stage('build jar') {
            steps {
                script{
                    echo 'Building the Spring boot application'
                    dir('SpringBoot') {
                        sh 'mvn package'
                    }
                }
            }
        }

     stage('build image') {
            steps {
                script{
                    echo 'building the docker image'
                    withCredentials([usernamePassword(credentialsId:'docker-hub-repo', passwordVariable:'PASS',usernameVariable:'USER')]){
                        sh 'docker build -t  rahmasassi/springboot ./SpringBoot/'
                        sh "echo $PASS | docker login -u $USER --password-stdin "
                        sh 'docker push rahmasassi/springboot'

                        sh 'docker build -t  rahmasassi/angular ./Angular/'
                        sh 'docker push rahmasassi/angular'
                    }
                }
            }
        }

        stage('Connect to EC2') {
            steps {
                sshagent(['ec2-server-key']) {
                    sh "ssh -T -o StrictHostKeyChecking=no ${SSH_USER}@${EC2_HOST}"
                }
            }
        }
        stage('Pull Docker image') {
            steps {
                sshagent(['ec2-server-key']) {
                    sh "ssh ${SSH_USER}@${EC2_HOST} docker container rm -f springboot"
                    sh "ssh ${SSH_USER}@${EC2_HOST} docker container rm -f angular"
                    sh "ssh ${SSH_USER}@${EC2_HOST} docker rmi \$(docker images -a -q) >/dev/null 2>&1 || true"
                    sh "ssh ${SSH_USER}@${EC2_HOST} docker pull  rahmasassi/springboot:latest"
                    sh "ssh ${SSH_USER}@${EC2_HOST} docker pull  rahmasassi/angular:latest"
                }
            }
        }


       stage('Run Docker container') {
            steps {
                sshagent(['ssh-key']) {
                    sh "ssh ${SSH_USER}@${EC2_HOST} docker network create my-network >/dev/null 2>&1 || true"
                    sh "ssh ${SSH_USER}@${EC2_HOST} docker run --rm --name springboot  --network my-network --hostname springboot -d  -p 8081:8081   rahmasassi/springboot:latest"
                    sh "ssh ${SSH_USER}@${EC2_HOST} docker run --rm  --name angular  --network my-network --hostname angular  -d -p 4200:4200   rahmasassi/angular:latest"
                }
            }
        }
    }

}