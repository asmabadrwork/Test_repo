pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'Java11'
    }

    parameters {
        choice(name: 'CHOICE', choices: ['Development', 'Staging', 'Production'], description: 'Pick environment')
        booleanParam(name: 'RUN_BUILD', defaultValue: true, description: 'Do you want to run build steps?')
    }

    environment {
        BUILD_ENV = "${params.CHOICE}"
        RUN_FLAG = "${params.RUN_BUILD}"
        url = ''
    }

    stages {
        stage('Clone') {
            steps {
                echo "Selected environment: ${BUILD_ENV}"
                git 'https://github.com/vaadin/addressbook.git'
                script {
                    env.url = 'https://www.google.com'
                    echo "URL set to ${env.url}"
                }
            }
        }

        stage('Test') {
            when {
                expression { params.RUN_BUILD }
            }
            steps {
                echo "Running tests..."
                sh 'mvn test'
            }
        }

        stage('Compile') {
            when {
                expression { params.RUN_BUILD }
            }
            steps {
                echo "Compiling code..."
                sh 'mvn compile'
            }
        }

        stage('Approval') {
            when {
                expression { params.RUN_BUILD }
            }
            steps {
                input message: 'Click "Proceed" to approve the build'
            }
        }

        stage('Package') {
            when {
                expression { params.RUN_BUILD }
            }
            steps {
                echo "Packaging the application..."
                sh 'mvn clean package'
            }
        }

        stage('Summary') {
            steps {
                echo " Pipeline completed for ${BUILD_ENV}."
                echo " Build steps were ${params.RUN_BUILD ? 'executed' : 'skipped'}."
            }
        }
    }

    post {
        success {
            echo ' Build finished successfully!'
        }
        failure {
            echo ' Build failed. Please check the console output for details.'
        }
        always {
            echo 'Cleaning workspace...'
            cleanWs()
        }
    }
}
