# ECE-Shopping

The goal of this project is to develop a shopping cart application that allows customers to purchase items with possible discounts and billing. The application will also assist the business organization of ECE Shopping to maintain and update its sales and customer records.

## Installation and running locally

ECE-Shopping is a [Spring Boot](https://spring.io/guides/gs/spring-boot/) application build using [Maven](https://spring.io/guides/gs/maven/) for the backend. As for the frontend, the application is a [Svelte Aplication](https://svelte.dev/) build with [Svelte kit](https://kit.svelte.dev/). You can clone this repository locally by running : 
```git
git clone https://github.com/BragdonD/ECE-Shopping.git
/// Will be updated later...
```

## Git Usage

This project uses the Git version control system to manage the source code. We follow the Gitflow branching model for our development workflow, which involves two main branches:
- ``main`` branch: This branch contains the stable, production-ready code. We only merge tested and verified code into this branch.
- ``develop`` branch: This branch serves as the integration branch where all feature branches are merged for testing and verification before merging into the main branch.

In addition to the two main branches, we also use ``feature`` branches for developing new features or fixing bugs. Feature branches are created from the ``develop`` branch and are named in the following convention:
````git
feature/<short-description>
````
For example, if you're working on a new login feature, you might create a feature branch named ``feature/login``.

Once you've completed your feature, you can create a pull request to merge your branch into the ``develop`` branch. After your code has been reviewed and approved, it will be merged into ``develop``.

When it's time to release a new version, we create a ``release`` branch from ``develop`` with the following naming convention:
```git
release/<version-number>
```
For example, if you're releasing version 1.0, you might create a release branch named ``release/1.0``. This branch will be used for final testing and bug fixes before merging into main for production release. To avoid any problem before merging into ``main``, we will also merge ``main`` into the release branch, resolve any potential problem and then remerge inside ``main``.

Finally, we also use the ``hotfix`` branch for emergency bug fixes in production. Hotfix branches are created from ``main`` and are named in the following convention:
```git
hotfix/<short-description>
```
For example, if you need to fix a critical bug in production, you might create a hotfix branch named ``hotfix/critical-bug-fix``. Once the hotfix has been tested and verified, it will be merged into ``main`` and ``develop``.

## Repport an issue
