pipeline {
    agent any

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

       


        stage('Deploy') {
            steps {
                echo "deploy"
            }
        }
    }

}