pipeline {
    agent any

    environment {
        SSH_USER = 'ec2-user'
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

        stage('provision server') {
            environment {
                AWS_ACCESS_KEY_ID = credentials('jenkins_aws_access_key_id')
                AWS_SECRET_ACCESS_KEY = credentials('jenkins_aws_secret_access_key') 
                AWS_SESSION_TOKEN = credentials('jenkins_aws_access_token')
                TF_VAR_env_prefix = 'test'
            }
            steps {
                script {
                    dir('terraform') {
                        sh "terraform init"
                        sh "terraform apply --auto-approve"
                        EC2_PUBLIC_IP = sh (
                            script: "terraform output ec2_public_ip",
                            returnStdout: true
                        ).trim()
                    }
                }
            }
        }

        stage('Connect to EC2') {
            steps {
                sshagent(['server-ssh-key']) {
                    sh "ssh -T -o StrictHostKeyChecking=no ${SSH_USER}@${EC2_PUBLIC_IP}"
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "waiting EC2 to initialize"
                    sleep(time: 90, unit: "SECONDS")

                    echo "${EC2_PUBLIC_IP}"

                    sshagent(['server-ssh-key']) {
                        sh "ssh ${SSH_USER}@${EC2_PUBLIC_IP} docker container rm -f springboot"
                        sh "ssh ${SSH_USER}@${EC2_PUBLIC_IP} docker container rm -f angular"
                        sh "ssh ${SSH_USER}@${EC2_PUBLIC_IP} docker rmi \$(docker images -a -q) >/dev/null 2>&1 || true"
                        sh "ssh ${SSH_USER}@${EC2_PUBLIC_IP} docker pull  rahmasassi/springboot:latest"
                        sh "ssh ${SSH_USER}@${EC2_PUBLIC_IP} docker pull  rahmasassi/angular:latest"
                        sh "ssh ${SSH_USER}@${EC2_PUBLIC_IP} docker network create my-network >/dev/null 2>&1 || true"
                        sh "ssh ${SSH_USER}@${EC2_PUBLIC_IP} docker run --name springboot --network my-network --hostname springboot -d -p 8081:8081 rahmasassi/springboot:latest"
                        sh "ssh ${SSH_USER}@${EC2_PUBLIC_IP} docker run --name angular --network my-network --hostname angular -d -p 4200:4200 rahmasassi/angular:latest"
                    }
                }
            }
        }
    }
}