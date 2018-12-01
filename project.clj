(defproject gnl/ghostwheel.unghost "0.3.0"
  :description "A tiny library used to remove Ghostwheel code in production"
  :url "https://github.com/gnl/ghostwheel.unghost"
  :scm {:name "git"
        :url  "https://github.com/gnl/ghostwheel.unghost"}
  :license {:name "Eclipse Public License"
            :url  "https://choosealicense.com/licenses/epl-2.0/"}
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :dependencies []
  :profiles {:dev {:dependencies [[org.clojure/clojurescript "1.10.439"]
                                  [org.clojure/clojure "1.9.0"]]}}
  :source-paths ["src"]
  :clean-targets ^{:protect false} ["target" "resources"])
