pipeline {
    agent none
    stages {
        stage('Cloning Git') {
            agent any
            steps {
                git 'https://github.com/averdier/enigma_jenkins_php'
            }
        }
        stage('Test') {
            agent { 
                docker {
                    image 'phpunit/phpunit:latest'
                    args "--entrypoint=''"
                }
            }
            steps {
                sh 'phpunit --bootstrap ExempleClass.php ExempleTest.php'
            }
        }
    }
}