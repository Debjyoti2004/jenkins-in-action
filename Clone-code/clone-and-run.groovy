// There You have to install node, npm

pipeline {
    agent any

    stages {
        stage('Verify Setup') {
            steps {
                sh '''
                node -v
                npm -v
                '''
                echo "Verifying Successfully"
                
            }
        }
        stage('Clone Code From GitHub') {
            steps {
                cleanWs()
                git branch: 'master', url: 'https://github.com/Debjyoti2004/node-jenkins-deploy.git'
                echo "Cloning code from GitHub Successfully"
            }
        }   
        stage ("Install Dependencies") {
            steps {
              sh "npm install"
              echo "Installing dependencies Successfully"
            }
        }
        stage("Run Application") {
            steps {
                echo "Running application Successfully"
                sh "node index.js"
            }
        }
    }
}