pipeline {

    agent any

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }
    }

    post {

        success {
            echo 'Course Registration System pipeline completed successfully.'
        }

        failure {
            echo 'Pipeline failed. Please check the Jenkins console output.'
        }
    }
}