(ns gws.mandrill.api.tags
  (:refer-clojure :exclude [list])
  (:require [gws.mandrill.api :refer [defapi]]))

(defapi list)
(defapi delete)
(defapi info)
(defapi time-series)
(defapi all-time-series)
