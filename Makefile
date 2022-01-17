JAVA_HOME := /opt/java/jdk1.8.0_231
GRADLE_HOME := /opt/gradle/gradle-6.5.1
#GRADLE_HOME := /opt/gradle/gradle-7.1.1
#GRADLE_HOME := /opt/gradle/gradle-7.3.3
PATH := $(JAVA_HOME)/bin:$(GRADLE_HOME)/bin:$(PATH)

export RELEASE_VERSION=$(shell cat release-version)
export SNAPSHOT_VERSION=$(shell cat snapshot-version)

snapshot:
	mvn versions:set -DnewVersion=$(SNAPSHOT_VERSION)-SNAPSHOT

version-release:
	mvn versions:set -DnewVersion=$(RELEASE_VERSION)

install:
	mvn install
publish:
	mvn publish
