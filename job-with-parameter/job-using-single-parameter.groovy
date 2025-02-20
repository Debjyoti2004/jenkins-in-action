pipeline {
    agent any

    stages {
        stage('Create A Folder') {
            steps {
                sh 'mkdir -p first-job'
            }
        }
        stage('Create A File Under The Folder') {
            steps {
                sh 'cd first-job && touch job.txt'
            }
        }
        stage('Put some data in the file') {
            steps {
                sh "echo ${FirstParameter} > first-job/job.txt"
            }
        }
    }
}
