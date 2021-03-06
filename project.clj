(defproject gov.usgs.eros/lcmap-system "1.0.0-SNAPSHOT"
  :description "LCMAP System"
  :url "https://github.com/usgs-eros/lcmap-system"
  :scm {
    :name "git"
    :url "https://github.com/usgs-eros/lcmap-system.git"}
  :license {
    :name "NASA Open Source Agreement, Version 1.3"
    :url "http://ti.arc.nasa.gov/opensource/nosa/"}
  :managed-dependencies [
    [byte-streams "0.2.2"]
    [camel-snake-kebab "0.4.0"]
    [clj-gdal "0.4.0-ALPHA"]
    [clj-http "3.1.0"]
    [clj-time "0.12.0"]
    [clj-time/clj-time "0.12.0"]
    [cljs-http "0.1.41"]
    [clojure-ini "0.0.2"]
    [clojurewerkz/cassaforte "2.0.2"]
    [spootnik/mesomatic "1.0.1-r0"]
    [spootnik/mesomatic-async "1.0.1-r0"]
    [clojusc/ring-xml "0.0.6"]
    [clojusc/twig "0.2.6"]
    [co.paralleluniverse/pulsar "0.7.6"]
    [com.cemerick/friend "0.2.3"]
    [com.cemerick/pomegranate "0.3.1"]
    [com.novemberain/langohr "3.6.1"]
    [com.stuartsierra/component "0.3.1"]
    [com.taoensso/timbre "4.7.4"]
    [commons-codec "1.10"]
    [compojure "1.5.1"]
    [digest "1.4.4"]
    [dire "0.5.4"]
    [environ "1.1.0"]
    [gov.usgs.eros/lcmap-client-clj "1.0.0-SNAPSHOT"]
    [gov.usgs.eros/lcmap-commons "1.0.0-SNAPSHOT"]
    [gov.usgs.eros/lcmap-config "1.0.0-SNAPSHOT"
      :exclusions [org.apache.maven.wagon/wagon-provider-api
                   org.codehaus.plexus/plexus-utils
                   org.slf4j/slf4j-api]]
    [gov.usgs.eros/lcmap-data "1.0.0-SNAPSHOT"]
    [gov.usgs.eros/lcmap-event "1.0.0-SNAPSHOT"]
    [gov.usgs.eros/lcmap-logger "1.0.0-SNAPSHOT"
      :exclusions [org.slf4j/slf4j-api
                   cheshire com.fasterxml.jackson.core/jackson-core
                   com.fasterxml.jackson.dataformat/jackson-dataformat-cbor
                   com.fasterxml.jackson.dataformat/jackson-dataformat-smile]]
    [gov.usgs.eros/lcmap-see "1.0.0-SNAPSHOT"]
    [http-kit "2.2.0"]
    [jmorton/ring-accept "0.2.0-SNAPSHOT"]
    [leiningen-core "2.7.0"
      :exclusions [org.codehaus.plexus/plexus-utils]]
    [me.raynes/fs "1.4.6"]
    [metrics-clojure "2.7.0"]
    [metrics-clojure-jvm "2.7.0"]
    [metrics-clojure-ring "2.7.0"]
    [net.jpountz.lz4/lz4 "1.3.0"]
    [org.apache.httpcomponents/httpclient "4.5.2"]
    [org.clojars.hozumi/clj-commons-exec "1.2.0"]
    [org.clojure/clojure "1.8.0"]
    [org.clojure/clojurescript "1.9.225"]
    [org.clojure/core.async "0.2.385"]
    [org.clojure/core.cache "0.6.5"]
    [org.clojure/core.match "0.3.0-alpha4"]
    [org.clojure/core.memoize "0.5.9"]
    [org.clojure/data.codec "0.1.0"]
    [org.clojure/data.json "0.2.6"]
    [org.clojure/data.xml "0.0.8"]
    [org.clojure/data.xml "0.1.0-beta1"]
    [org.clojure/data.zip "0.1.2"]
    [org.clojure/tools.cli "0.3.5"]
    [org.clojure/tools.namespace "0.3.0-alpha3"]
    [org.xerial.snappy/snappy-java "1.1.2.6"]
    [pandect "0.6.0"]
    [prismatic/schema "1.1.3"]
    [ring.middleware.logger "0.5.0" :exclusions [org.slf4j/slf4j-log4j12]]
    [ring/ring-core "1.5.0"]
    [ring/ring-defaults "0.2.1"]
    [ring/ring-devel "1.5.0"]
    [ring/ring-jetty-adapter "1.5.0"]
    [ring/ring-json "0.4.0"]
    [slamhound "1.5.5"]
    [slingshot "0.12.2"]]
  :plugins [
    [jonase/eastwood "0.2.3" :exclusions [org.clojure/clojure]]
    [lein-cljsbuild "1.1.4"]
    [lein-codox "0.10.1"]
    [lein-environ "1.1.0"]
    [lein-kibit "0.1.2" :exclusions [org.clojure/clojure]]
    [lein-pprint "1.1.2"]
    [lein-ring "0.9.7"]
    [lein-simpleton "1.3.0"]]
  ;; XXX Right now, jarkeeper.com doesn't know what to do with dependencies
  ;; that don't have a version number, and thus counts them as out of date.
  ;; Until that is fixed, we'll put version number here, too: (at least that's
  ;; better than maintaining different ones in different *files* ...)
  :dependencies [
    [clojusc/twig "0.2.6"]
    [org.clojure/clojure "1.8.0"]
    [org.clojure/tools.namespace "0.3.0-alpha3"]]
  :repl-options {:init-ns lcmap.system.dev}
  :target-path "target/%s"
  ;; XXX The following profiles cannot be used until this issue is resolved:
  ;;     * https://github.com/achin/lein-parent/issues/3
  :profiles {
    :uberjar {:aot :all}
    :dev {
      :source-paths ["dev-resources/src"]
      ;; XXX Same note about deps versions here as above
      :dependencies [[slamhound "1.5.5"]]
      :aliases {"slamhound" ["run" "-m" "slam.hound"]}}}
  :test-selectors {
    :default (complement :integration)
    :unit    (complement :integration)
    :db      :integration
    :all     (constantly true)}
  ;; Maven Stuff
  :pom-addition [
    :developers [
      :developer [:name "LCMAP Dev Team"]
                 [:organization "USGS-EROS"]
                 [:url "https://github.com/orgs/usgs-eros/teams/lcmap"]]]
  :repositories [
    ["maven" {
      :url "https://oss.sonatype.org/content/repositories/snapshots/"
      :creds :gpg}]]
  :deploy-repositories [
    ["releases" {
      :url "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
      :creds :gpg}
     "snapshots" {
      :url "https://oss.sonatype.org/content/repositories/snapshots/"
      :creds :gpg}]])

