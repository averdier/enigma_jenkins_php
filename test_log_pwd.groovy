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
        shell("docker container create --name dummygroovy -v tempvolumegroovy:/app hello-world")
        shell('docker cp "$(pwd)/." dummygroovy:/app')
        shell("docker rm dummygroovy")
        shell("docker run -v tempvolumegroovy:/app --rm phpunit/phpunit:latest --bootstrap ExempleClass.php ExempleTest.php")
        shell("docker volume rm tempvolumegroovy")
    }
}