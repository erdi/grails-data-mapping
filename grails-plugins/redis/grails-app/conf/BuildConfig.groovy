grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {

    inherits( "global" ) {
		excludes 'xml-apis', 'netty'
	}

    log "warn"
	
	def version = "1.0.0.groovy-1.7-M5"
	def repo = version.endsWith("-SNAPSHOT") ? 'snapshot' : 'milestone'
	
    repositories {
        mavenRepo "http://maven.springframework.org/$repo"
        mavenCentral()
		grailsCentral()
    }

    dependencies {
		compile( 'redis.clients:jedis:1.5.2' )
        compile("org.grails:grails-datastore-gorm-redis:$version",
				"org.grails:grails-datastore-gorm:$version",
				"org.springframework:spring-datastore-core:$version",
				"org.springframework:spring-datastore-redis:$version",
				"org.springframework:spring-datastore-web:$version") {
			transitive = false
		}
        test("org.grails:grails-datastore-gorm-test:$version",
			 "org.springframework:spring-datastore-simple:$version"){
			transitive = false
		} 
    }

    plugins {
        build( ":maven-publisher:0.7.5" ) {
            export = false
        }
    }
}
