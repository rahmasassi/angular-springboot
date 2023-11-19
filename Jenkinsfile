pipeline {
    agent any

    tools{
        maven 'maven-3.6'
    }

    stages {
        stage('build jar') {
            steps {
                script{
                    echo 'building the application'
                    sh 'mvn package'
                }
            }
        }

        stage('build image') {
            steps {
                script{
                    echo 'building the docker image'
                    withCredentials([usernamePassword(credentialsId:'docker-hub-repo', passwordVariable:'PASS',usernameVariable:'USER')]){
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker build -t  rahmasassi/springboot ./SpringBoot/'
                        sh "echo $PASS | docker login -u $USER --password-stdin "
                        sh 'docker push rahmasassi/springboot'
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