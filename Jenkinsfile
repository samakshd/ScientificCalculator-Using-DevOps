pipeline {    

    // Declare variables that will be used by the later stages
    environment {
        GITHUB_REPO_URL = 'https://github.com/samakshd/ScientificCalculator-Using-DevOps.git'
        GITHUB_CREDENTIALS = 'github-id'
        DOCKERHUB_REGISTRY = "samakshd/scientific-calculator-using-devops"
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-id')
    }

    // The "agent" section configures on which nodes the pipeline can be 
    // run. Specifying "agent any" means that Jenkins will run the job on  
    // any of the available nodes.
    agent any 
    
    stages {
        
        stage('Git Pull') {
            steps {
                // credentials are required because its a private repository
                git url: GITHUB_REPO_URL,
                branch: 'master',
                credentialsId: GITHUB_CREDENTIALS
            }
        }
        
        stage('Maven Build + JUnit Tests') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}

