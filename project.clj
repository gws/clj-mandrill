(defproject gws/clj-mandrill "0.4.2"
  :description "A Clojure implementation of the Mandrill API"
  :url "https://gitlab.com/gws/clj-mandrill"
  :min-lein-version "2.0.0"
  :license {:name "Apache 2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[cheshire "5.5.0"]
                 [clj-http "2.1.0"]]
  :global-vars {*warn-on-reflection* true}
  :plugins [[lein-codox "0.9.4"]]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.8.0"]]
                   :plugins [[jonase/eastwood "0.2.3"]]}}
  :test-selectors {:default (complement :integration)
                   :integration :integration})
