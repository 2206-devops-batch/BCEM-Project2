pipeline {
    agent any
    stages {
        stage{"test"} {

            steps {
                sh "echo pwd"
                sh '''sudo yum install python3 -y
                sudo yum install pip -y
                sudo yum install docker -y
                pip install -r requirements.txt
                python3 -m pytest app-test.py
                sudo docker login -u ${env.DOCK_USER} -p ${env.DOCK_PASS}
                sudo docker build /home/ec2-user/workspace/BCEM-Project2 -t chamoo334/p2
                sudo docker push caerbear/revature:latest
                '''
            }
        }
        stage("build and run") {
            steps {
                
                // login to dep server
                sshagent(credentials : ['dep-server']) {
                    sh "echo pwd"
                    sh ''' 
                    sudo docker login -u ${env.DOCK_USER} -p ${env.DOCK_PASS}
                    sudo docker pull chamoo334/p2:latest
                    sudo docker run chamoo334/p2 --name p2_app
                    '''
                }

            }
        }
    }
}