// This is the simple code to clone the code from GitHub

pipeline {
    agent any // This is the agent that will run the pipeline, till now we have not defined any agent thats why it is any

    stages {
        stage('Clone Code From GitHub') {
            steps {
                cleanWs() // This is used to clean the workspace before the pipeline starts
                
                script {
                    try {
                        git branch: 'master',
                            url: 'https://github.com/Debjyoti2004/Nginx_Simple_Project.git'
                    } catch (Exception e) {
                        error "Failed to clone repository: ${e.getMessage()}"
                    }
                }
            }
        }
    }
}
