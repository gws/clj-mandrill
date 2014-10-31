(ns gws.mandrill.api.templates
  (:refer-clojure :exclude [list])
  (:require [gws.mandrill.api :refer [defapi]]))

(defapi add)
(defapi info)
(defapi update)
(defapi publish)
(defapi delete)
(defapi list)
(defapi time-series)
(defapi render)
