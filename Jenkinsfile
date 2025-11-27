pipeline {
    agent any

    tools {
        // Optionally configure Maven tool name in Jenkins Global Tool Configuration
        // maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checkout from SCM"
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                echo "Run mvn clean test"
                sh 'mvn -B clean test'
            }
        }
    }

    post {
        always {
            // Publish JUnit results to Jenkins
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
