(ns gws.mandrill.client-test
  (:require [clojure.test :refer :all]
            [gws.mandrill.client :as c])
  (:import (gws.mandrill.client MandrillClient)))

(def api-key
  (System/getenv "MANDRILL_TEST_API_KEY"))

(deftest create
  (is (instance? MandrillClient (c/create api-key)))
  (is (instance? MandrillClient (c/create api-key {:debug true}))))
