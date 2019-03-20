pipeline {
    agent none
    stages {
        agent any
        stage('Cloning Git') {
            steps {
                git 'https://github.com/gustavoapolinario/node-todo-frontend'
            }
        }
        stage('Test') {
            agent { docker 'phpunit/phpunit:latest' }
            steps {
                sh 'phpunit --bootstrap ExempleClass.php ExempleTest.php'
            }
        }
    }
}