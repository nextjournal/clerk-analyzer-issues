(ns libpython-clj
  (:require [libpython-clj2.python :as py]
            [libpython-clj2.require :refer [require-python]]
            [nextjournal.clerk :as clerk]))

(py/initialize!)

(require-python '[re])

(let [ptrn (re/compile "pattern")]

  (py/py. ptrn search "pattern"))

(comment

  ;; The alter-var-root workaround will not work if called before require-python
  (do
    (alter-var-root #'nextjournal.clerk.analyzer/throw-if-dep-is-missing (constantly (fn [_ _ _])))
    (clerk/show! "py_clj_src/libpython_clj.clj"))


  ;; But if require-python is called before analysis, it will work as expected
  ;; even without alter-var-root
  (do
    (require-python '[re])
    (clerk/show! "py_clj_src/libpython_clj.clj")
    )

  )
