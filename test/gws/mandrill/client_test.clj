(ns gws.mandrill.client-test
  (:require [clojure.test :refer :all]
            [gws.mandrill.client :as c])
  (:import (gws.mandrill.client MandrillClient)))

(def ^:private test-api-key
  (System/getenv "MANDRILL_TEST_API_KEY"))

(def ^:private msg1
  {:message {:to [{:email "foo@bar.com"
                   :name "Foo Bar"}]
             :from_email "foo@bar.com"}})

(deftest create
  (is (instance? MandrillClient (c/create test-api-key)))
  (is (instance? MandrillClient (c/create test-api-key {:debug true}))))

(deftest messages-send
  (let [client (c/create test-api-key)
        response (c/messages-send client msg1)
        first-response (first response)]
    (is (= "foo@bar.com" (:email first-response)))
    (is (= "sent" (:status first-response)))))
