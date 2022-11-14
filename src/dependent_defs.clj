(ns dependent-defs
  (:require [macros :refer [dep-def]]
            [nextjournal.clerk :as clerk]))

(dep-def X)
(dep-def Y X)
