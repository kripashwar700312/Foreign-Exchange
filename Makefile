default:
	cat ./Makefile
dist:
	./mvnw clean package
image:
	docker build -f Dockerfile -t fx-docker .
run:
	sudo docker run -p 8090:8090 fx-docker