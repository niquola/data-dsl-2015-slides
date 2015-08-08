(ns ddsls.core)

(defmacro what [& args])
(defmacro why [& args])
(defmacro how [& args])
(defmacro example [& args])
(defn slide [& num] num)

(what is DSL?)
;;=> "Domain Specific Language"
(what another name for dsl?)

(what exaples of DSL?)

[:sql :css :html :bash]
(what non-programmers dsl?)
(what unusual dsl?)
'(math dsl)
'(chemistry dsl)
(why DSL?)

(why DSL?)

'(Complexity)
'(Size)

(how small it could be?)

'(Alan Kay "Reinventing Programming")

(def size-of-moder-stack
  (Math/pow 10 7))

(def desired-size
  (Math/pow 10 4))

(/ size-of-moder-stack
   desired-size)

(def RFC-ASCI-SPEC
"0                   1                   2                   3
 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|Ver= 4 |IHL= 8 |Type of Service|       Total Length = 576      |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|       Identification = 111    |Flg=0|     Fragment Offset = 0 |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   Time = 123  |  Protocol = 6 |       Header Checksum         |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|                        source address                         |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|                      destination address                      |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| Opt. Code = x | Opt.  Len.= 3 | option value  | Opt. Code = x |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| Opt. Len. = 4 |           option value        | Opt. Code = 1 |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| Opt. Code = y | Opt. Len. = 3 |  option value | Opt. Code = 0 |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|                             data                              |
|                             data                              |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|                             data                              |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
")

(defn interpret [rfc-asci])



(def LANGUAGE-ORIENTED-PROGRAMMING)

'(not (code solution))

'((code DSLs)  solution)

(example
 (FermatT
    LISP -> WSL -> MetaWSL -> Transformation ))

'(MORE pluses of DSL
       (decrease requirements to programmers upto non-programmers)
       (involve domain experts))


'(DSL CLASSIFICATION
    (external DSL
            [:sql :sed :etc])
    (embeded DSLs
            [:regexp :linq :OCaml])
    (internal DSLs
            [:meta-programming :macro-programming]))


(def External-DSL
  ^{:+  "expressivnes"
    :-  "recreate whole eco-system"}
  '(grammar interpeter ide))

(interpretator format)


(require '[route-map :as route-map])
'(url -> vec)
"user/1/new" => ["users" 1 "new" :get]

(def routes
  {:GET    'root
   "files" {:path* {:GET 'file}}
   "users" {:midleware ['ensure-admin]
            :GET  'list
            :POST 'create
            [:uid] {:GET 'show
                    :PUT 'udpate
                    :DELETE 'destroy}}})

(route-map/match [:get "/unexisting"] routes) ;;=> nil
(route-map/match [:get "/users/1"] routes)
;;=> {:match 'show
;;    :parents [all nodes in path to match]
;;    :params {:uid "1"}}

(route-map/match [:get "/files/assets/img/icon.png"] routes)
;;=> {:match 'file
;;    :params {:path* ["assets" "img" "icon.png"]}
;;    :parents ...}


(require '[hiccup.core :as hc])

(hc/html [:a {:href "http://github.com"} "GitHub"])

(defn link-to [url txt] [:a {:href url} txt])

(def template
  [:ul
   (for [x (range 10)]
     (link-to x x))])



(hc/html template)

(require '[honeysql.core :as sql])

(defn myfn [tbl]
  {:select [:*]
   :from [:users]
   :where [:= :id "ups"]})

(defn myfn-2 [tbl]
  {:select [:*]
   :from [tbl]
   :where [:= :id "ups"]})


(sql/format
 {:select [:f.* :b.baz :c.quux [:b.bla "bla-bla"] (sql/call :now)]
  :modifiers [:distinct]
  :from [[:foo :f] [:baz :b]]
  :join [:draq [:= :f.b :draq.x]]
  :left-join [[:clod :c] [:= :f.a :c.d]]
  :right-join [:bock [:= :bock.z :c.e]]
  :where [:or
          [:and [:= :f.a "bort"] [:not= :b.baz (sql/param :param1)]]
          [:< 1 2 3]
          [:in :f.e [1 (sql/param :param2) 3]]
          [:between :f.e 10 20]]
  :group-by [:f.a]
  :having [:< 0 :f.e]
  :order-by [[:b.baz :desc] :c.quux [:f.a :nulls-first]]
  :limit 50
  :offset 10})



(require '[schema.core :as s])

(def Schema
  {:a {:b s/Str
       :c s/Int}
   :d [{:e s/Keyword
        :f [s/Num]}]})

(def data {:a {:b 1 :c 2}})

(s/validate Schema data)

(s/check Schema data)




(require '[plumbing.core :refer (sum fnk)])
(require '[plumbing.graph :as graph])

(def stats-graph
    "A graph specifying the same computation as 'stats'"
    {:n  (fnk [xs]   (count xs))
     :m  (fnk [xs n] (/ (sum identity xs) n))
     :m2 (fnk [xs n] (/ (sum #(* % %) xs) n))
     :v  (fnk [m m2] (- m2 (* m m)))})

(def stats-eager (graph/compile stats-graph))
(def lazy-stats (graph/lazy-compile stats-graph))

(into {} (stats-eager {:xs [1 2 3 6]}))































