# objective: create a vagrant instance that runs docker

vagrantfile_api_version = "2"

Vagrant.configure(vagrantfile_api_version) do |config|

  config.vm.box = "ubuntu/trusty64"
  config.vm.hostname = "docker"
  config.vm.provision "shell", path: "./docker_create_tomcat.sh"
  config.vm.network :forwarded_port, guest: 8080, host: 8080

end
