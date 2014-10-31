(ns gws.mandrill.api
  (:require [gws.mandrill.client :as c]
            [clojure.string :as s]))

(defmacro defapi
  [call]
  (let [mandrill-ns (last (s/split (str *ns*) #"\."))
        endpoint (str mandrill-ns "/" call)]
    `(defn ~call
       ~(str "https://mandrillapp.com/api/docs/" mandrill-ns ".JSON.html#method=" call)
       [~'client ~'request]
       (c/call ~'client ~endpoint ~'request))))
