job('Test PWD Groovy job') {
    scm {
        git('https://github.com/averdier/enigma_jenkins_php') {  node -> 
            node / gitConfigName('rastadev')
            node / gitConfigEmail('arthur@elonet.fr')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    steps {
        shell('ls')
    }
}