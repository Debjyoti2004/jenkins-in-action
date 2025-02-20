pipeline {
    agent { label 'dev' }

    stages {
        stage('Verify Setup') {
            steps {
                sh '''
                node -v
                npm -v
                '''
                echo 'Verifying Setup Successfully'
            }
        }
        stage('Clone Code From GitHub') {
            steps {
                cleanWs()
                git branch: 'master', url: 'https://github.com/Debjyoti2004/node-jenkins-deploy.git'
                echo 'Cloning code from GitHub Successfully'
            }
        }
        stage('Install Dependencies') {
            steps {
                sh 'npm install'
                echo 'Installing dependencies Successfully'
            }
        }
        stage('Run Application with PM2') {
            steps {
                echo 'Running application using PM2'
                sh '''
                npx pm2 delete my-node-app || true
                npx pm2 start index.js --name my-node-app
                npx pm2 save
                '''
                echo 'Application started and saved successfully in PM2'
            }
        }
    }
}
