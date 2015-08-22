(ns gws.mandrill.api.subaccounts
  (:refer-clojure :exclude [list update])
  (:require [gws.mandrill.api :refer [defapi]]))

(defapi list)
(defapi add)
(defapi info)
(defapi update)
(defapi delete)
(defapi pause)
(defapi resume)
