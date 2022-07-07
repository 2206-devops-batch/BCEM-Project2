pipeline {
    agent any
    stages {
        stage{"test"} {

            steps {
                sh '''sudo yum install python3 -y
                sudo yum install pip -y
                sudo yum install docker
                pip install -r requirements.txt
                python3 -m pytest app-test.py
                sudo docker build /home/ec2-user/workspace/BCEM-Project2 -t chamoo334/revature
                sudo docker push caerbear/revature:latest
                '''
            }
        }
        stage("build and run") {
            steps {
                
                // login to dep server
                sshagent(credentials : ['dep-server']) {
                    sh ''' 
                    sudo docker build /home/ec2-user/workspace/BCEM-Project2 -t chamoo334/revature
                    sudo docker push caerbear/revature:latest
                    '''
                }

            }
        }
    }
}