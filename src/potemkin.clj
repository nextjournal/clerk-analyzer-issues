(ns potemkin
  {:nextjournal.clerk/no-cache true}
  (:require [nextjournal.clerk :as clerk]
            [potemkin.types]
            [potemkin.collections :as c]))

(c/def-map-type M [m]
  (get [_ k dv] (clojure.core/get m k dv))
  (assoc [_ k v] (M. (assoc m k v)))
  (dissoc [_ k] (M. (dissoc m k)))
  (keys [_] (keys m)))

(->M {:a 1 :b 2})

;; Execution error (ExceptionInfo) at nextjournal.clerk.analyzer/throw-if-dep-is-missing (analyzer.clj:254).
;; a first show!
;; Attempting to call unbound fn: #'potemkin/->M (why?)
;; second time
;; The var `#'potemkin/->M` exists at runtime, but Clerk cannot find it in the namespace. Did you remove it?

;; `def-map-type` -> `deftype+` is memoizing type declarations at macro-expand time and _won't_ emitt the constructor definitions (e.g. `->M`)
;; when invoked a second time if the type has been defined already. See reset instructions below

(comment
  ;; reset
  (doseq [[n _] (ns-publics *ns*)] (ns-unmap *ns* n))
  (reset! potemkin.types/type-bodies {})
  (keys @potemkin.types/type-bodies)

  ;; and evaluate one the 2 forms below twice
  (nextjournal.clerk.analyzer/analyze
   '(c/def-map-type M [m]
      (get [_ k dv] (clojure.core/get m k dv))
      (assoc [_ k v] (M. (assoc m k v)))
      (dissoc [_ k] (M. (dissoc m k)))
      (keys [_] (keys m))))

  (clojure.tools.analyzer.jvm/macroexpand-all
   '(c/def-map-type M [m]
      (get [_ k dv] (clojure.core/get m k dv))
      (assoc [_ k v] (M. (assoc m k v)))
      (dissoc [_ k] (M. (dissoc m k)))
      (keys [_] (keys m))))

)
