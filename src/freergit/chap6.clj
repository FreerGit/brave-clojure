(ns freergit.chap6
  (:require [clojure.core/str :as s]))

(ns-name *ns*)

(def books ["bla" " bla "])

(ns-interns *ns*)

(create-ns 'cheese.taxonomy)
(ns-name (create-ns 'cheese.taxonomy))

