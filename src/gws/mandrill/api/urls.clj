(ns gws.mandrill.api.urls
  (:refer-clojure :exclude [list])
  (:require [gws.mandrill.api :refer [defapi]]))

(defapi list)
(defapi search)
(defapi time-series)
(defapi tracking-domains)
(defapi add-tracking-domain)
(defapi check-tracking-domain)
