(ns gws.mandrill.api.inbound
  (:require [gws.mandrill.api :refer [defapi]]))

(defapi domains)
(defapi add-domain)
(defapi check-domain)
(defapi delete-domain)
(defapi routes)
(defapi add-route)
(defapi update-route)
(defapi delete-route)
(defapi send-raw)
