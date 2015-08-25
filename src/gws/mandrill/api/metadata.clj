(ns gws.mandrill.api.metadata
  (:refer-clojure :exclude [list update])
  (:require [gws.mandrill.api :refer [defapi]]))

(defapi list)
(defapi add)
(defapi update)
(defapi delete)
