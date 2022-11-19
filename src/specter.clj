(ns specter
  (:require [com.rpl.specter :as s]
            [nextjournal.clerk :as clerk]))


;; the below will collect all numbers in the collection into a vector
(s/select (s/walker number?)
          {:a 1})

(comment
  (clerk/serve! {:port 7788 })
  (nextjournal.clerk/show! "src/specter.clj")
  ;; `clerk/show!` throws
  ;; "The var `#'specter/pathcache23969` exists at runtime, but Clerk cannot find it in the namespace. Did you remove it?"
  
  *e  ;; =>
;; #error {
;;  :cause "The var `#'specter/pathcache23969` exists at runtime, but Clerk cannot find it in the namespace. Did you remove it?"
;;  :data {:var-name specter/pathcache23969, :form (s/select (s/walker number?) {:a 1}), :file "src/specter.clj"}
;;  :via
;;  [{:type clojure.lang.ExceptionInfo
;;    :message "The var `#'specter/pathcache23969` exists at runtime, but Clerk cannot find it in the namespace. Did you remove it?"
;;    :data {:var-name specter/pathcache23969, :form (s/select (s/walker number?) {:a 1}), :file "src/specter.clj"}
;;    :at [nextjournal.clerk.analyzer$throw_if_dep_is_missing invokeStatic "analyzer.clj" 254]}]
;;  :trace
;;  [[nextjournal.clerk.analyzer$throw_if_dep_is_missing invokeStatic "analyzer.clj" 254]
;;   [nextjournal.clerk.analyzer$throw_if_dep_is_missing invoke "analyzer.clj" 247]
;;   [nextjournal.clerk.analyzer$analyze_doc$fn__20068 invoke "analyzer.clj" 282]
;;   [clojure.lang.Range reduce "Range.java" 180]
;;   [clojure.core$reduce invokeStatic "core.clj" 6885]
;;   [clojure.core$reduce invoke "core.clj" 6868]
;;   [nextjournal.clerk.analyzer$analyze_doc invokeStatic "analyzer.clj" 262]
;;   [nextjournal.clerk.analyzer$analyze_doc invoke "analyzer.clj" 257]
;;   [nextjournal.clerk.analyzer$analyze_doc invokeStatic "analyzer.clj" 259]
;;   [nextjournal.clerk.analyzer$analyze_doc invoke "analyzer.clj" 257]
;;   [nextjournal.clerk.analyzer$build_graph invokeStatic "analyzer.clj" 381]
;;   [nextjournal.clerk.analyzer$build_graph invoke "analyzer.clj" 375]
;;   [nextjournal.clerk.eval$_PLUS_eval_results invokeStatic "eval.clj" 198]
;;   [nextjournal.clerk.eval$_PLUS_eval_results invoke "eval.clj" 195]
;;   [nextjournal.clerk$show_BANG_ invokeStatic "clerk.clj" 58]
;;   [nextjournal.clerk$show_BANG_ invoke "clerk.clj" 23]
;;   [specter$eval23953 invokeStatic "NO_SOURCE_FILE" 14]
;;   [specter$eval23953 invoke "NO_SOURCE_FILE" 14]
;;   [clojure.lang.Compiler eval "Compiler.java" 7194]
;;   [clojure.lang.Compiler eval "Compiler.java" 7149]
;;   [clojure.core$eval invokeStatic "core.clj" 3215]
;;   [clojure.core$eval invoke "core.clj" 3211]
;;   [nrepl.middleware.interruptible_eval$evaluate$fn__1245$fn__1246 invoke "interruptible_eval.clj" 87]
;;   [clojure.lang.AFn applyToHelper "AFn.java" 152]
;;   [clojure.lang.AFn applyTo "AFn.java" 144]
;;   [clojure.core$apply invokeStatic "core.clj" 667]
;;   [clojure.core$with_bindings_STAR_ invokeStatic "core.clj" 1990]
;;   [clojure.core$with_bindings_STAR_ doInvoke "core.clj" 1990]
;;   [clojure.lang.RestFn invoke "RestFn.java" 425]
;;   [nrepl.middleware.interruptible_eval$evaluate$fn__1245 invoke "interruptible_eval.clj" 87]
;;   [clojure.main$repl$read_eval_print__9206$fn__9209 invoke "main.clj" 437]
;;   [clojure.main$repl$read_eval_print__9206 invoke "main.clj" 437]
;;   [clojure.main$repl$fn__9215 invoke "main.clj" 458]
;;   [clojure.main$repl invokeStatic "main.clj" 458]
;;   [clojure.main$repl doInvoke "main.clj" 368]
;;   [clojure.lang.RestFn invoke "RestFn.java" 1523]
;;   [nrepl.middleware.interruptible_eval$evaluate invokeStatic "interruptible_eval.clj" 84]
;;   [nrepl.middleware.interruptible_eval$evaluate invoke "interruptible_eval.clj" 56]
;;   [nrepl.middleware.interruptible_eval$interruptible_eval$fn__1278$fn__1282 invoke "interruptible_eval.clj" 152]
;;   [clojure.lang.AFn run "AFn.java" 22]
;;   [nrepl.middleware.session$session_exec$main_loop__1348$fn__1352 invoke "session.clj" 218]
;;   [nrepl.middleware.session$session_exec$main_loop__1348 invoke "session.clj" 217]
;;   [clojure.lang.AFn run "AFn.java" 22]
;;   [java.lang.Thread run "Thread.java" 833]]}
  )

