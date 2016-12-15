(defproject gws/clj-mandrill "0.4.5"
  :description "A Clojure implementation of the Mandrill API"
  :url "https://gitlab.com/gws/clj-mandrill"
  :min-lein-version "2.0.0"
  :license {:name "Apache 2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[cheshire "5.6.3"]
                 [clj-http "3.4.1"]]
  :profiles {:dev {:plugins [[jonase/eastwood "0.2.3"]
                             [lein-codox "0.9.4"]]
                   :global-vars {*warn-on-reflection* true}}
             :provided {:dependencies [[org.clojure/clojure "1.8.0"]]}}
  :test-selectors {:default (complement :integration)
                   :integration :integration})
