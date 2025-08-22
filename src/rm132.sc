;;; Sierra Script 1.0 - (do not remove this comment)
(script# 132)
(include sci.sh)
(use Main)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm132 0
)

(local
	local0 =  3
)
(instance rm132 of Rm
	(properties
		picture 32
		style $800a
		horizon 50
		vanishingX 130
		vanishingY 50
	)
	
	(method (init)
		(super init:)
		(global2 setScript: sFryRat)
	)
)

(instance sFryRat of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gSq5Music2 number: 142 setLoop: 1 play:)
				(= ticks 6)
			)
			(1 (rat init:) (= ticks 6))
			(2
				(rat posn: 174 25)
				(= ticks 6)
			)
			(3
				(rat posn: 164 39)
				(= ticks 6)
			)
			(4
				(rat setLoop: 1 posn: 160 46)
				(ratHead init:)
				(= ticks 6)
			)
			(5 (ratEyes init:) (= ticks 6))
			(6 (ratEyes hide:) (= ticks 6))
			(7 (ratEyes show:) (= ticks 6))
			(8 (ratEyes hide:) (= ticks 6))
			(9
				(ratHead setLoop: 1 setCel: 2 posn: 156 50)
				(= ticks 6)
			)
			(10 (= ticks 6))
			(11
				(ratEyes show: setLoop: 6 setCel: 0 posn: 160 66)
				(= ticks 6)
			)
			(12
				(ratEyes hide:)
				(= ticks 6)
			)
			(13 (= ticks 6))
			(14
				(ratHead setCel: 3 posn: 151 52)
				(= ticks 6)
			)
			(15
				(ratHead posn: 151 49)
				(= ticks 6)
			)
			(16 (= ticks 6))
			(17
				(ratEyes show: setLoop: 8 posn: 161 52)
				(= ticks 6)
			)
			(18
				(ratEyes hide:)
				(= ticks 6)
			)
			(19
				(ratEyes show:)
				(= ticks 6)
			)
			(20
				(ratEyes hide:)
				(= ticks 6)
			)
			(21 (= ticks 1))
			(22
				(ratEyes dispose:)
				(ratHead dispose:)
				(rat
					scaleSignal: 1
					scaleX: 133
					scaleY: 133
					setLoop: 2
					setCel: 0
					posn: 149 21
				)
				(= ticks 2)
			)
			(23
				(rat scaleSignal: 1 scaleX: 128 scaleY: 128 posn: 139 14)
				(= ticks 2)
			)
			(24
				(rat posn: 118 17)
				(= ticks 2)
			)
			(25
				(rat scaleSignal: 1 scaleX: 115 scaleY: 115 posn: 106 27)
				(= ticks 2)
			)
			(26
				(rat scaleSignal: 1 scaleX: 107 scaleY: 107 posn: 93 40)
				(= ticks 2)
			)
			(27
				(rat scaleSignal: 1 scaleX: 101 scaleY: 101 posn: 75 55)
				(= ticks 2)
			)
			(28
				(rat dispose:)
				(gSq5Music2 number: 145 setLoop: 1 play:)
				(sparks init: setCycle: Fwd)
				(= ticks 6)
			)
			(29
				(sparks dispose:)
				(shine1 init:)
				(shine2 init:)
				(shine3 init:)
				(Palette palSET_FROM_RESOURCE 322 2)
				(= ticks 1)
			)
			(30
				(gSq5Music2 number: 146 setLoop: 1 play:)
				(shine1 hide:)
				(shine2 hide:)
				(shine3 hide:)
				(Palette palSET_FROM_RESOURCE 32 2)
				(= ticks 5)
			)
			(31
				(shine1 show:)
				(shine2 show:)
				(shine3 show:)
				(Palette palSET_FROM_RESOURCE 322 2)
				(if (> (-- local0) 0) (= state (- state 2)))
				(= ticks 5)
			)
			(32
				(Palette palSET_FROM_RESOURCE 32 2)
				(shine1 dispose:)
				(shine2 dispose:)
				(shine3 dispose:)
				(gSq5Music2 stop:)
				(proc0_2 7)
				(= ticks 1)
			)
			(33 (global2 newRoom: 127))
		)
	)
)

(instance mouseHead of Actor
	(properties
		x 172
		y 40
		view 145
		loop 8
		priority 5
		signal $0010
	)
)

(instance inMouse of Actor
	(properties
		x 247
		y 56
		view 145
		signal $6000
		cycleSpeed 10
		moveSpeed 10
	)
)

(instance sparks of Prop
	(properties
		x 113
		y 91
		view 145
		loop 5
		priority 15
		signal $0010
	)
)

(instance shine1 of View
	(properties
		x 93
		y 28
		view 145
		loop 7
	)
)

(instance shine2 of View
	(properties
		x 94
		y 79
		view 145
		loop 7
		cel 1
		priority 20
		signal $0010
	)
)

(instance shine3 of View
	(properties
		x 158
		y 62
		view 145
		loop 7
		cel 2
	)
)

(instance rat of Actor
	(properties
		x 184
		y 12
		view 145
	)
)

(instance ratHead of Actor
	(properties
		x 155
		y 47
		view 145
		loop 1
		cel 1
		signal $4000
	)
)

(instance ratEyes of Actor
	(properties
		x 161
		y 57
		view 145
		loop 4
	)
)
