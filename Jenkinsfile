pipeline {
    agent any
    environment {
        // IMPORTANT: Change this to your Docker Hub username
        DOCKER_IMAGE = 'your-dockerhub-username/java-docker-app'
        REGISTRY_CREDENTIALS = 'dockerhub-credentials'
    }
    stages {
        stage('Checkout') {
            steps {
                // IMPORTANT: Change this to your GitHub repository URL
                git 'https://github.com/aman123443/Docker_Java_app.git'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Builds an image and tags it with the build number (e.g., 1, 2, 3)
                    docker.build("${DOCKER_IMAGE}:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('Push to Docker Hub') {
            steps {
                script {
                    // Logs into Docker Hub using the credentials we added to Jenkins
                    docker.withRegistry('https://registry.hub.docker.com', REGISTRY_CREDENTIALS) {
                        // Pushes the image
                        docker.image("${DOCKER_IMAGE}:${env.BUILD_NUMBER}").push()
                    }
                }
            }
        }
    }
}