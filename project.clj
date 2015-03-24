(defproject gws/clj-mandrill "0.2.2"
  :description "A Clojure implementation of the Mandrill API"
  :url "https://gitlab.com/gws/clj-mandrill"
  :min-lein-version "2.0.0"
  :license {:name "Apache 2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[cheshire "5.4.0"]
                 [clj-http "1.1.0"]]
  :global-vars {*warn-on-reflection* true}
  :plugins [[codox "0.8.10"]]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :test {:plugins [[jonase/eastwood "0.2.1"]]}}
  :test-selectors {:default (complement :integration)
                   :integration :integration})
