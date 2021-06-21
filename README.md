# Expert Consultation App

[![GitHub contributors](https://img.shields.io/github/contributors/code4romania/expert-consultation-backend.svg)](https://github.com/code4romania/expert-consultation-backend/graphs/contributors) [![GitHub last commit](https://img.shields.io/github/last-commit/code4romania/expert-consultation-backend.svg)](https://github.com/code4romania/expert-consultation-backend/commits/master) [![License: MPL 2.0](https://img.shields.io/badge/license-MPL%202.0-brightgreen.svg)](https://opensource.org/licenses/MPL-2.0) ![](https://github.com/code4romania/expert-consultation-backend/workflows/Build/badge.svg)

**Check out the [Wiki](https://github.com/code4romania/expert-consultation-backend/wiki)!**

Expert Consultation is prototyped and developed by [Code for Romania](https://code4.ro/ro).

Expert Consultation is an application meant to allow a public institution (or any other entity) to create a piece of legislation, proposal or any other type of document and to initiate a round of consultation with experts. The experts in this platform are organized in gorups (NGOs, associations etc.) and they can add their opinions to each individual part of the consulted document. At the end of this process, each group will create a restructured version of the initial document and sent it upstream, to the institution or entity that organized the consultation.

Expert Consultation is  a project that has been researched and prototyped in [Civic Labs](https://civiclabs.ro/ro).

The app is under development, in [Tech for Social Good](https://tfsg.code4.ro/ro/).

[Contributing](#contributing) | [Built with](#built-with) | [Repos and projects](#repos-and-projects)
| [Deployment](#deployment) | [Feedback](#feedback) | [License](#license) | [About Code4Ro](#about-code4ro)

## Contributing

This project is built by amazing volunteers and you can be one of them! Here's a list of ways
in [which you can contribute to this project](.github/CONTRIBUTING.md). If you want to make any change to this
repository, please **make a fork first**.

Help us out by testing this project in the [staging environment](https://expert-consultation-client.now.sh/home). If you
see something that doesn't quite work the way you expect it to, open an Issue. Make sure to describe what you _expect to
happen_ and _what is actually happening_ in detail.

If you would like to suggest new functionality, open an Issue and mark it as a __[Feature request]__. Please be specific
about why you think this functionality will be of use. If you can, please include some visual description of what you
would like the UI to look like, if you are suggesting new UI elements.

Also, this is [the workflow we follow](.github/WORKFLOW.md).

## Built With

### Programming languages

Java 11

### Platforms

Spring Boot 2.5

### Frontend framework

### Package managers

Gradle

### Database technology & provider

PostgreSQL

## Repos and projects

- [Expert Consultation Client](https://github.com/code4romania/expert-consultation-frontend)

## Deployment

- gradlew clean build
- gradlew spring-boot:run

### [With docker-compose](etc/docker/README.md)

### Server dependencies

#### Manual

##### Database

* install PostgreSQL server
* set the root password
* create a database called `expertconsultation`

#### [With docker-compose](etc/docker/README.md)

### Local testing

## Feedback

* Request a new feature on GitHub.
* Vote for popular feature requests.
* File a bug in GitHub Issues.
* Email us with other feedback contact@code4.ro

## License

This project is licensed under the MPL 2.0 License - see the [LICENSE](LICENSE) file for details

## About Code4Ro

Started in 2016, Code for Romania is a civic tech NGO, official member of the Code for All network. We have a community
of over 500 volunteers (developers, ux/ui, communications, data scientists, graphic designers, devops, it security and
more) who work pro-bono for developing digital solutions to solve social problems. #techforsocialgood. If you want to
learn more details about our projects [visit our site](https://www.code4.ro/en/) or if you want to talk to one of our
staff members, please e-mail us at contact@code4.ro.

Last, but not least, we rely on donations to ensure the infrastructure, logistics and management of our community that
is widely spread across 11 timezones, coding for social change to make Romania and the world a better place. If you want
to support us, [you can do it here](https://code4.ro/en/donate/).
