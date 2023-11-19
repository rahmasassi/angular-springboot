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
                    dir('SpringBoot') {
                        sh 'mvn package'
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