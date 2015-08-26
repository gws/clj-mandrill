(ns gws.mandrill.client
  (:require [cheshire.core :as json]
            [clj-http.client :as http]))

(defrecord MandrillClient [api-key clj-http-options])

(def endpoint-fmt "https://mandrillapp.com/api/1.0/%s.json")
(def user-agent "clj-mandrill/0.3.0 (https://github.com/gws/clj-mandrill)")

(defn call
  "Calls the supplied Mandrill endpoint and returns the decoded response body."
  [client endpoint body]
  (let [body (update-in body [:key] #(or % (:api-key client)))
        params (merge {:as :json
                       :content-type :json
                       :headers {"User-Agent" user-agent}
                       :body (json/generate-string body)}
                      (:clj-http-options client))]
    (:body (http/post (format endpoint-fmt endpoint) params))))

(defn create
  "Build a Mandrill client, containing an optional map of parameters which,
   if specified, will be merged into the clj-http parameter map."
  [api-key & [clj-http-options]]
  (->MandrillClient api-key (or clj-http-options {})))
