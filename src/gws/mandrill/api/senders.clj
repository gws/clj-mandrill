(ns gws.mandrill.api.senders
  (:refer-clojure :exclude [list])
  (:require [gws.mandrill.api :refer [defapi]]))

(defapi list)
(defapi domains)
(defapi add-domain)
(defapi check-domain)
(defapi verify-domain)
(defapi info)
(defapi time-series)
