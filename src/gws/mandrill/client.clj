(ns gws.mandrill.client
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defrecord MandrillClient [api-key clj-http-options])

(def ^:private base-url "https://mandrillapp.com/api/1.0/")
(def ^:private user-agent "gws-mandrill/0.1.0")

(defn- build-endpoint
  [call]
  (str base-url call ".json"))

(defn- call
  "Calls the supplied Mandrill endpoint and returns the decoded response body."
  [client endpoint body]
  {:pre [(instance? MandrillClient client)]}
  (let [body (assoc body :key (or (:key body) (:api-key client)))
        params (-> {:as :json
                    :content-type :json
                    :headers {"User-Agent" user-agent}
                    :body (json/write-str body)}
                   (merge (:clj-http-options client)))]
    (:body (client/post (build-endpoint endpoint) params))))

(defn create
  "Build a Mandrill client, containing an optional map of parameters which,
   if specified, will be merged into the clj-http parameter map."
  [api-key & [clj-http-options]]
  (let [clj-http-options (or clj-http-options {})]
    (->MandrillClient api-key clj-http-options)))

(defn messages-send
  "https://mandrillapp.com/api/docs/messages.JSON.html#method=send"
  [client request]
  (call client "messages/send" request))

(defn messages-send-template
  "https://mandrillapp.com/api/docs/messages.JSON.html#method=send-template"
  [client request]
  (call client "messages/send-template" request))

(defn messages-search
  "https://mandrillapp.com/api/docs/messages.JSON.html#method=search"
  [client request]
  (call client "messages/search" request))

(defn messages-search-time-series
  "https://mandrillapp.com/api/docs/messages.JSON.html#method=search-time-series"
  [client request]
  (call client "messages/search-time-series" request))

(defn messages-info
  "https://mandrillapp.com/api/docs/messages.JSON.html#method=info"
  [client request]
  (call client "messages/info" request))

(defn messages-content
  "https://mandrillapp.com/api/docs/messages.JSON.html#method=content"
  [client request]
  (call client "messages/content" request))

(defn messages-parse
  "https://mandrillapp.com/api/docs/messages.JSON.html#method=parse"
  [client request]
  (call client "messages/parse" request))

(defn messages-send-raw
  "https://mandrillapp.com/api/docs/messages.JSON.html#method=send-raw"
  [client request]
  (call client "messages/send-raw" request))

(defn messages-list-scheduled
  "https://mandrillapp.com/api/docs/messages.JSON.html#method=list-scheduled"
  [client request]
  (call client "messages/list-scheduled" request))

(defn messages-cancel-scheduled
  "https://mandrillapp.com/api/docs/messages.JSON.html#method=cancel-scheduled"
  [client request]
  (call client "messages/cancel-scheduled" request))

(defn messages-reschedule
  "https://mandrillapp.com/api/docs/messages.JSON.html#method=reschedule"
  [client request]
  (call client "messages/reschedule" request))
