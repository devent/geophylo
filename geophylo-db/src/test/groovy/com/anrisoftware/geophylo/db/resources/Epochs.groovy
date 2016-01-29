package com.anrisoftware.geophylo.db.resources

import java.awt.Color

import com.anrisoftware.geophylo.db.hibernate.EpochEntity.EpochEntityFactory
import com.anrisoftware.geophylo.db.model.Rank

// Precambrian

def precambrian = ((EpochEntityFactory)(epochEntityFactory)).create()
precambrian.preferred = 'Precambrian'
precambrian.rank = Rank.supereon
precambrian.olderBound = 4600
precambrian.youngerBound = 541
precambrian.color = Color.decode '#F16782'
precambrian.names = [:]
precambrian.names << [(Locale.ENGLISH): 'Precambrian']
precambrian.names << [(Locale.GERMAN): 'Präkambrium']
precambrian.narrower = []

// Hadean -> Precambrian

def hadean = ((EpochEntityFactory)(epochEntityFactory)).create()
hadean.preferred = 'Hadean'
hadean.rank = Rank.eon
hadean.olderBound = 4600
hadean.youngerBound = 4000
hadean.color = Color.decode '#B41E8E'
hadean.names = [:]
hadean.names << [(Locale.ENGLISH): 'Hadean']
hadean.names << [(Locale.GERMAN): 'Hadaikum']
hadean.broader = precambrian
precambrian.narrower << hadean

// Archean -> Precambrian

def archean = ((EpochEntityFactory)(epochEntityFactory)).create()
archean.preferred = 'Archean'
archean.rank = Rank.eon
archean.olderBound = 4000
archean.youngerBound = 2500
archean.color = Color.decode '#EC008C'
archean.names = [:]
archean.names << [(Locale.ENGLISH): 'Archean']
archean.names << [(Locale.GERMAN): 'Archaikum']
archean.broader = precambrian
archean.narrower = []
precambrian.narrower << archean

def eoarchean = ((EpochEntityFactory)(epochEntityFactory)).create()
eoarchean.preferred = 'Eoarchean'
eoarchean.rank = Rank.era
eoarchean.olderBound = 4000
eoarchean.youngerBound = 3600
eoarchean.color = Color.decode '#D80A8C'
eoarchean.names = [:]
eoarchean.names << [(Locale.ENGLISH): 'Eoarchean']
eoarchean.names << [(Locale.GERMAN): 'Eoarchaikum']
eoarchean.broader = archean
archean.narrower << eoarchean

def paleoarchean = ((EpochEntityFactory)(epochEntityFactory)).create()
paleoarchean.preferred = 'Paleoarchean'
paleoarchean.rank = Rank.era
paleoarchean.olderBound = 3600
paleoarchean.youngerBound = 3200
paleoarchean.color = Color.decode '#F067A6'
paleoarchean.names = [:]
paleoarchean.names << [(Locale.ENGLISH): 'Paleoarchean']
paleoarchean.names << [(Locale.GERMAN): 'Paläoarchaikum']
paleoarchean.broader = archean
archean.narrower << paleoarchean

def mesoarchean = ((EpochEntityFactory)(epochEntityFactory)).create()
mesoarchean.preferred = 'Mesoarchean'
mesoarchean.rank = Rank.era
mesoarchean.olderBound = 3200
mesoarchean.youngerBound = 2800
mesoarchean.color = Color.decode '#F386AE'
mesoarchean.names = [:]
mesoarchean.names << [(Locale.ENGLISH): 'Mesoarchean']
mesoarchean.names << [(Locale.GERMAN): 'Mesoarchaikum']
mesoarchean.broader = archean
archean.narrower << mesoarchean

def neoarchean = ((EpochEntityFactory)(epochEntityFactory)).create()
neoarchean.preferred = 'Neoarchean'
neoarchean.rank = Rank.era
neoarchean.olderBound = 2800
neoarchean.youngerBound = 2500
neoarchean.color = Color.decode '#F7ADC3'
neoarchean.names = [:]
neoarchean.names << [(Locale.ENGLISH): 'Neoarchean']
neoarchean.names << [(Locale.GERMAN): 'Neoarchaikum']
neoarchean.broader = archean
archean.narrower << neoarchean

// Proterozoic -> Precambrian

def proterozoic = ((EpochEntityFactory)(epochEntityFactory)).create()
proterozoic.preferred = 'Proterozoic'
proterozoic.rank = Rank.eon
proterozoic.olderBound = 4000
proterozoic.youngerBound = 2500
proterozoic.color = Color.decode '#F05B78'
proterozoic.names = [:]
proterozoic.names << [(Locale.ENGLISH): 'Proterozoic']
proterozoic.names << [(Locale.GERMAN): 'Proterozoikum']
proterozoic.broader = precambrian
proterozoic.narrower = []
precambrian.narrower << proterozoic

// Paleoproterozoic -> Proterozoic -> Precambrian

def paleoproterozoic = ((EpochEntityFactory)(epochEntityFactory)).create()
paleoproterozoic.preferred = 'Paleoproterozoic'
paleoproterozoic.rank = Rank.era
paleoproterozoic.olderBound = 2500
paleoproterozoic.youngerBound = 1600
paleoproterozoic.color = Color.decode '#F16782'
paleoproterozoic.names = [:]
paleoproterozoic.names << [(Locale.ENGLISH): 'Paleoproterozoic']
paleoproterozoic.names << [(Locale.GERMAN): 'Paläoproterozoikum']
paleoproterozoic.broader = proterozoic
paleoproterozoic.narrower = []
proterozoic.narrower << paleoproterozoic

def siderian = ((EpochEntityFactory)(epochEntityFactory)).create()
siderian.preferred = 'Siderian'
siderian.rank = Rank.period
siderian.olderBound = 2500
siderian.youngerBound = 2300
siderian.color = Color.decode '#F2728C'
siderian.names = [:]
siderian.names << [(Locale.ENGLISH): 'Siderian']
siderian.names << [(Locale.GERMAN): 'Siderium']
siderian.broader = paleoproterozoic
paleoproterozoic.narrower << siderian

def rhyacian = ((EpochEntityFactory)(epochEntityFactory)).create()
rhyacian.preferred = 'Rhyacian'
rhyacian.rank = Rank.period
rhyacian.olderBound = 2300
rhyacian.youngerBound = 2050
rhyacian.color = Color.decode '#F27C96'
rhyacian.names = [:]
rhyacian.names << [(Locale.ENGLISH): 'Rhyacian']
rhyacian.names << [(Locale.GERMAN): 'Rhyacium']
rhyacian.broader = paleoproterozoic
paleoproterozoic.narrower << rhyacian

def orosirian = ((EpochEntityFactory)(epochEntityFactory)).create()
orosirian.preferred = 'Orosirian'
orosirian.rank = Rank.period
orosirian.olderBound = 2050
orosirian.youngerBound = 1800
orosirian.color = Color.decode '#F386A1'
orosirian.names = [:]
orosirian.names << [(Locale.ENGLISH): 'Orosirian']
orosirian.names << [(Locale.GERMAN): 'Orosirium']
orosirian.broader = paleoproterozoic
paleoproterozoic.narrower << orosirian

def statherian = ((EpochEntityFactory)(epochEntityFactory)).create()
statherian.preferred = 'Statherian'
statherian.rank = Rank.period
statherian.olderBound = 1800
statherian.youngerBound = 1600
statherian.color = Color.decode '#F490AD'
statherian.names = [:]
statherian.names << [(Locale.ENGLISH): 'Statherian']
statherian.names << [(Locale.GERMAN): 'Statherium']
statherian.broader = paleoproterozoic
paleoproterozoic.narrower << statherian

// Mesoproterozoic -> Proterozoic -> Precambrian

def mesoproterozoic = ((EpochEntityFactory)(epochEntityFactory)).create()
mesoproterozoic.preferred = 'Mesoproterozoic'
mesoproterozoic.rank = Rank.era
mesoproterozoic.olderBound = 1600
mesoproterozoic.youngerBound = 1000
mesoproterozoic.color = Color.decode '#FCBC7E'
mesoproterozoic.names = [:]
mesoproterozoic.names << [(Locale.ENGLISH): 'Mesoproterozoic']
mesoproterozoic.names << [(Locale.GERMAN): 'Mesoproterozoikum']
mesoproterozoic.broader = proterozoic
mesoproterozoic.narrower = []
proterozoic.narrower << mesoproterozoic

def calymmian = ((EpochEntityFactory)(epochEntityFactory)).create()
calymmian.preferred = 'Calymmian'
calymmian.rank = Rank.period
calymmian.olderBound = 1600
calymmian.youngerBound = 1400
calymmian.color = Color.decode '#FDC692'
calymmian.names = [:]
calymmian.names << [(Locale.ENGLISH): 'Calymmian']
calymmian.names << [(Locale.GERMAN): 'Calymmium']
calymmian.broader = mesoproterozoic
mesoproterozoic.narrower << calymmian

def ectasian = ((EpochEntityFactory)(epochEntityFactory)).create()
ectasian.preferred = 'Ectasian'
ectasian.rank = Rank.period
ectasian.olderBound = 1400
ectasian.youngerBound = 1200
ectasian.color = Color.decode '#FED09E'
ectasian.names = [:]
ectasian.names << [(Locale.ENGLISH): 'Ectasian']
ectasian.names << [(Locale.GERMAN): 'Ectasium']
ectasian.broader = mesoproterozoic
mesoproterozoic.narrower << ectasian

def stenian = ((EpochEntityFactory)(epochEntityFactory)).create()
stenian.preferred = 'Stenian'
stenian.rank = Rank.period
stenian.olderBound = 1200
stenian.youngerBound = 1000
stenian.color = Color.decode '#FFDBAB'
stenian.names = [:]
stenian.names << [(Locale.ENGLISH): 'Stenian']
stenian.names << [(Locale.GERMAN): 'Stenium']
stenian.broader = mesoproterozoic
mesoproterozoic.narrower << stenian

// Neoproterozoic -> Proterozoic -> Precambrian

def neoproterozoic = ((EpochEntityFactory)(epochEntityFactory)).create()
neoproterozoic.preferred = 'Neoproterozoic'
neoproterozoic.rank = Rank.era
neoproterozoic.olderBound = 1000
neoproterozoic.youngerBound = 541
neoproterozoic.color = Color.decode '#FDBB63'
neoproterozoic.names = [:]
neoproterozoic.names << [(Locale.ENGLISH): 'Neoproterozoic']
neoproterozoic.names << [(Locale.GERMAN): 'Neoproterozoikum']
neoproterozoic.broader = proterozoic
neoproterozoic.narrower = []
proterozoic.narrower << neoproterozoic

def tonian = ((EpochEntityFactory)(epochEntityFactory)).create()
tonian.preferred = 'Tonian'
tonian.rank = Rank.period
tonian.olderBound = 1000
tonian.youngerBound = 720
tonian.color = Color.decode '#FEC46F'
tonian.names = [:]
tonian.names << [(Locale.ENGLISH): 'Tonian']
tonian.names << [(Locale.GERMAN): 'Tonium']
tonian.broader = neoproterozoic
neoproterozoic.narrower << tonian

def cryogenian = ((EpochEntityFactory)(epochEntityFactory)).create()
cryogenian.preferred = 'Cryogenian'
cryogenian.rank = Rank.period
cryogenian.olderBound = 720
cryogenian.youngerBound = 635
cryogenian.color = Color.decode '#FFCE7B'
cryogenian.names = [:]
cryogenian.names << [(Locale.ENGLISH): 'Cryogenian']
cryogenian.names << [(Locale.GERMAN): 'Cryogenium']
cryogenian.broader = neoproterozoic
cryogenian.narrower = []
neoproterozoic.narrower << cryogenian

def sturtian = ((EpochEntityFactory)(epochEntityFactory)).create()
sturtian.preferred = 'Sturtian glaciation'
sturtian.rank = Rank.glaciation
sturtian.olderBound = 720
sturtian.youngerBound = 660
sturtian.color = Color.decode '#27A1D9'
sturtian.names = [:]
sturtian.names << [(Locale.ENGLISH): 'Sturtian glaciation']
sturtian.names << [(Locale.GERMAN): 'Sturtische Eiszeit']
sturtian.broader = cryogenian
cryogenian.narrower << sturtian

def marinoan = ((EpochEntityFactory)(epochEntityFactory)).create()
marinoan.preferred = 'Marinoan glaciation'
marinoan.rank = Rank.glaciation
marinoan.olderBound = 650
marinoan.youngerBound = 635
marinoan.color = Color.decode '#27A1D9'
marinoan.names = [:]
marinoan.names << [(Locale.ENGLISH): 'Marinoan glaciation']
marinoan.names << [(Locale.GERMAN): 'Marinoische Eiszeit']
marinoan.broader = cryogenian
cryogenian.narrower << marinoan

def ediacaran = ((EpochEntityFactory)(epochEntityFactory)).create()
ediacaran.preferred = 'Ediacaran'
ediacaran.rank = Rank.period
ediacaran.olderBound = 635
ediacaran.youngerBound = 541
ediacaran.color = Color.decode '#FFD887'
ediacaran.names = [:]
ediacaran.names << [(Locale.ENGLISH): 'Ediacaran']
ediacaran.names << [(Locale.GERMAN): 'Ediacarium']
ediacaran.broader = neoproterozoic
neoproterozoic.narrower << ediacaran

// Phanerozoic

def phanerozoic = ((EpochEntityFactory)(epochEntityFactory)).create()
phanerozoic.preferred = 'Phanerozoic'
phanerozoic.rank = Rank.eon
phanerozoic.olderBound = 541
phanerozoic.youngerBound = 0
phanerozoic.color = Color.decode '#90D7EC'
phanerozoic.names = [:]
phanerozoic.names << [(Locale.ENGLISH): 'Phanerozoic']
phanerozoic.names << [(Locale.GERMAN): 'Phanerozoikum']
phanerozoic.narrower = []

// Paleozoic -> Phanerozoic

def paleozoic = ((EpochEntityFactory)(epochEntityFactory)).create()
paleozoic.preferred = 'Paleozoic'
paleozoic.rank = Rank.era
paleozoic.olderBound = 541
paleozoic.youngerBound = 252.17
paleozoic.color = Color.decode '#9EC2A6'
paleozoic.names = [:]
paleozoic.names << [(Locale.ENGLISH): 'Paleozoic']
paleozoic.names << [(Locale.GERMAN): 'Paläozoikum']
paleozoic.broader = phanerozoic
paleozoic.narrower = []
phanerozoic.narrower << paleozoic

// Cambrian -> Paleozoic -> Phanerozoic

def cambrian = ((EpochEntityFactory)(epochEntityFactory)).create()
cambrian.preferred = 'Cambrian'
cambrian.rank = Rank.period
cambrian.olderBound = 541
cambrian.youngerBound = 485.4
cambrian.color = Color.decode '#8BAB79'
cambrian.names = [:]
cambrian.names << [(Locale.ENGLISH): 'Cambrian']
cambrian.names << [(Locale.GERMAN): 'Kambrium']
cambrian.broader = paleozoic
cambrian.narrower = []
paleozoic.narrower << cambrian

// Terreneuvian -> Cambrian -> Paleozoic -> Phanerozoic

def terreneuvian = ((EpochEntityFactory)(epochEntityFactory)).create()
terreneuvian.preferred = 'Terreneuvian'
terreneuvian.rank = Rank.epoch
terreneuvian.olderBound = 541.0
terreneuvian.youngerBound = 521
terreneuvian.color = Color.decode '#95B68B'
terreneuvian.names = [:]
terreneuvian.names << [(Locale.ENGLISH): 'Terreneuvian']
terreneuvian.names << [(Locale.GERMAN): 'Terreneuvium']
terreneuvian.broader = cambrian
terreneuvian.narrower = []
cambrian.narrower << terreneuvian

// Fortunian -> Terreneuvian -> Cambrian -> Paleozoic -> Phanerozoic

def fortunian = ((EpochEntityFactory)(epochEntityFactory)).create()
fortunian.preferred = 'Fortunian'
fortunian.rank = Rank.age
fortunian.olderBound = 541.0
fortunian.youngerBound = 529
fortunian.color = Color.decode '#A0BA92'
fortunian.names = [:]
fortunian.names << [(Locale.ENGLISH): 'Fortunian']
fortunian.names << [(Locale.GERMAN): 'Fortunium']
fortunian.broader = terreneuvian
terreneuvian.narrower << fortunian

// Stage 2 -> Terreneuvian -> Cambrian -> Paleozoic -> Phanerozoic

def stage_2 = ((EpochEntityFactory)(epochEntityFactory)).create()
stage_2.preferred = 'Stage 2'
stage_2.rank = Rank.age
stage_2.olderBound = 529.0
stage_2.youngerBound = 521
stage_2.color = Color.decode '#ACBE9A'
stage_2.names = [:]
stage_2.names << [(Locale.ENGLISH): 'Stage 2']
stage_2.names << [(Locale.GERMAN): 'Stage 2']
stage_2.broader = terreneuvian
terreneuvian.narrower << stage_2

// Series 2 -> Cambrian -> Paleozoic -> Phanerozoic

def series_2 = ((EpochEntityFactory)(epochEntityFactory)).create()
series_2.preferred = 'Series 2'
series_2.rank = Rank.epoch
series_2.olderBound = 521.0
series_2.youngerBound = 509
series_2.color = Color.decode '#9FC195'
series_2.names = [:]
series_2.names << [(Locale.ENGLISH): 'Series 2']
series_2.names << [(Locale.GERMAN): 'Series 2']
series_2.broader = cambrian
series_2.narrower = []
cambrian.narrower << series_2

def stage_3 = ((EpochEntityFactory)(epochEntityFactory)).create()
stage_3.preferred = 'Stage 3'
stage_3.rank = Rank.age
stage_3.olderBound = 521.0
stage_3.youngerBound = 514
stage_3.color = Color.decode '#ABC59D'
stage_3.names = [:]
stage_3.names << [(Locale.ENGLISH): 'Stage 3']
stage_3.names << [(Locale.GERMAN): 'Stage 3']
stage_3.broader = series_2
series_2.narrower << stage_3

def stage_4 = ((EpochEntityFactory)(epochEntityFactory)).create()
stage_4.preferred = 'Stage 4'
stage_4.rank = Rank.age
stage_4.olderBound = 521.0
stage_4.youngerBound = 514
stage_4.color = Color.decode '#ABC59D'
stage_4.names = [:]
stage_4.names << [(Locale.ENGLISH): 'Stage 4']
stage_4.names << [(Locale.GERMAN): 'Stage 4']
stage_4.broader = series_2
series_2.narrower << stage_4

// Series 3 -> Cambrian -> Paleozoic -> Phanerozoic

def series_3 = ((EpochEntityFactory)(epochEntityFactory)).create()
series_3.preferred = 'Series 3'
series_3.rank = Rank.epoch
series_3.olderBound = 509.0
series_3.youngerBound = 497
series_3.color = Color.decode '#ABCDA0'
series_3.names = [:]
series_3.names << [(Locale.ENGLISH): 'Series 3']
series_3.names << [(Locale.GERMAN): 'Series 3']
series_3.broader = cambrian
series_3.narrower = []
cambrian.narrower << series_3

def stage_5 = ((EpochEntityFactory)(epochEntityFactory)).create()
stage_5.preferred = 'Stage 5'
stage_5.rank = Rank.age
stage_5.olderBound = 509.0
stage_5.youngerBound = 504.5
stage_5.color = Color.decode '#B7D1A9'
stage_5.names = [:]
stage_5.names << [(Locale.ENGLISH): 'Stage 5']
stage_5.names << [(Locale.GERMAN): 'Stage 5']
stage_5.broader = series_3
series_3.narrower << stage_5

def drumian = ((EpochEntityFactory)(epochEntityFactory)).create()
drumian.preferred = 'Drumian'
drumian.rank = Rank.age
drumian.olderBound = 504.5
drumian.youngerBound = 500.5
drumian.color = Color.decode '#C2D6B2'
drumian.names = [:]
drumian.names << [(Locale.ENGLISH): 'Drumian']
drumian.names << [(Locale.GERMAN): 'Drumium']
drumian.broader = series_3
series_3.narrower << drumian

def guzhangian = ((EpochEntityFactory)(epochEntityFactory)).create()
guzhangian.preferred = 'Guzhangian'
guzhangian.rank = Rank.age
guzhangian.olderBound = 500.5
guzhangian.youngerBound = 497
guzhangian.color = Color.decode '#CEDBBC'
guzhangian.names = [:]
guzhangian.names << [(Locale.ENGLISH): 'Guzhangian']
guzhangian.names << [(Locale.GERMAN): 'Guzhangium']
guzhangian.broader = series_3
series_3.narrower << guzhangian

// Furongian -> Cambrian -> Paleozoic -> Phanerozoic

def furongian = ((EpochEntityFactory)(epochEntityFactory)).create()
furongian.preferred = 'Furongian'
furongian.rank = Rank.epoch
furongian.olderBound = 497
furongian.youngerBound = 485.4
furongian.color = Color.decode '#B6DCAE'
furongian.names = [:]
furongian.names << [(Locale.ENGLISH): 'Furongian']
furongian.names << [(Locale.GERMAN): 'Furongium']
furongian.broader = cambrian
furongian.narrower = []
cambrian.narrower << furongian

def paibian = ((EpochEntityFactory)(epochEntityFactory)).create()
paibian.preferred = 'Paibian'
paibian.rank = Rank.age
paibian.olderBound = 497
paibian.youngerBound = 494
paibian.color = Color.decode '#CEE6C1'
paibian.names = [:]
paibian.names << [(Locale.ENGLISH): 'Paibian']
paibian.names << [(Locale.GERMAN): 'Paibium']
paibian.broader = furongian
furongian.narrower << paibian

def jiangshanian = ((EpochEntityFactory)(epochEntityFactory)).create()
jiangshanian.preferred = 'Jiangshanian'
jiangshanian.rank = Rank.age
jiangshanian.olderBound = 494
jiangshanian.youngerBound = 489.5
jiangshanian.color = Color.decode '#DAEBCA'
jiangshanian.names = [:]
jiangshanian.names << [(Locale.ENGLISH): 'Jiangshanian']
jiangshanian.names << [(Locale.GERMAN): 'Jiangshanium']
jiangshanian.broader = furongian
furongian.narrower << jiangshanian

def stage_10 = ((EpochEntityFactory)(epochEntityFactory)).create()
stage_10.preferred = 'Stage 10'
stage_10.rank = Rank.age
stage_10.olderBound = 489.5
stage_10.youngerBound = 485.4
stage_10.color = Color.decode '#E6F1D4'
stage_10.names = [:]
stage_10.names << [(Locale.ENGLISH): 'Stage 10']
stage_10.names << [(Locale.GERMAN): 'Stage 10']
stage_10.broader = furongian
furongian.narrower << stage_10

// Ordovician -> Paleozoic -> Phanerozoic

def ordovician = ((EpochEntityFactory)(epochEntityFactory)).create()
ordovician.preferred = 'Ordovician'
ordovician.rank = Rank.period
ordovician.olderBound = 485.4
ordovician.youngerBound = 443.8
ordovician.color = Color.decode '#07A897'
ordovician.names = [:]
ordovician.names << [(Locale.ENGLISH): 'Ordovician']
ordovician.names << [(Locale.GERMAN): 'Ordovizium']
ordovician.broader = paleozoic
ordovician.narrower = []
paleozoic.narrower << ordovician

// Lower -> Ordovician -> Paleozoic -> Phanerozoic

def lower = ((EpochEntityFactory)(epochEntityFactory)).create()
lower.preferred = 'Lower'
lower.rank = Rank.epoch
lower.olderBound = 485.4
lower.youngerBound = 470
lower.color = Color.decode '#00AE8E'
lower.names = [:]
lower.names << [(Locale.ENGLISH): 'Lower Ordovician']
lower.names << [(Locale.GERMAN): 'Unterordovizium']
lower.broader = ordovician
lower.narrower = []
ordovician.narrower << lower

def tremadocian = ((EpochEntityFactory)(epochEntityFactory)).create()
tremadocian.preferred = 'Tremadocian'
tremadocian.rank = Rank.age
tremadocian.olderBound = 485.4
tremadocian.youngerBound = 477.7
tremadocian.color = Color.decode '#00AE8E'
tremadocian.names = [:]
tremadocian.names << [(Locale.ENGLISH): 'Tremadocian']
tremadocian.names << [(Locale.GERMAN): 'Tremadocium']
tremadocian.broader = lower
lower.narrower << tremadocian

def floian = ((EpochEntityFactory)(epochEntityFactory)).create()
floian.preferred = 'Floian'
floian.rank = Rank.age
floian.olderBound = 477.7
floian.youngerBound = 470.0
floian.color = Color.decode '#00AE8E'
floian.names = [:]
floian.names << [(Locale.ENGLISH): 'Floian']
floian.names << [(Locale.GERMAN): 'Floium']
floian.broader = lower
lower.narrower << floian

// Middle -> Ordovician -> Paleozoic -> Phanerozoic

def middle = ((EpochEntityFactory)(epochEntityFactory)).create()
middle.preferred = 'Middle'
middle.rank = Rank.epoch
middle.olderBound = 470
middle.youngerBound = 458.4
middle.color = Color.decode '#00AE8E'
middle.names = [:]
middle.names << [(Locale.ENGLISH): 'Middle Ordovician']
middle.names << [(Locale.GERMAN): 'Mittelordovizium']
middle.broader = ordovician
middle.narrower = []
ordovician.narrower << middle

def dapingian = ((EpochEntityFactory)(epochEntityFactory)).create()
dapingian.preferred = 'Dapingian'
dapingian.rank = Rank.age
dapingian.olderBound = 470.0
dapingian.youngerBound = 467.3
dapingian.color = Color.decode '#60C3AD'
dapingian.names = [:]
dapingian.names << [(Locale.ENGLISH): 'Dapingian']
dapingian.names << [(Locale.GERMAN): 'Dapingium']
dapingian.broader = middle
middle.narrower << dapingian

def darriwilian = ((EpochEntityFactory)(epochEntityFactory)).create()
darriwilian.preferred = 'Darriwilian'
darriwilian.rank = Rank.age
darriwilian.olderBound = 467.3
darriwilian.youngerBound = 458.4
darriwilian.color = Color.decode '#6FC8B6'
darriwilian.names = [:]
darriwilian.names << [(Locale.ENGLISH): 'Darriwilian']
darriwilian.names << [(Locale.GERMAN): 'Darriwilium']
darriwilian.broader = middle
middle.narrower << darriwilian

// Upper -> Ordovician -> Paleozoic -> Phanerozoic

def upper = ((EpochEntityFactory)(epochEntityFactory)).create()
upper.preferred = 'Upper'
upper.rank = Rank.epoch
upper.olderBound = 458.4
upper.youngerBound = 443.8
upper.color = Color.decode '#80CBAE'
upper.names = [:]
upper.names << [(Locale.ENGLISH): 'Upper Ordovician']
upper.names << [(Locale.GERMAN): 'Oberordovizium']
upper.broader = ordovician
upper.narrower = []
ordovician.narrower << upper

def sandbian = ((EpochEntityFactory)(epochEntityFactory)).create()
sandbian.preferred = 'Sandbian'
sandbian.rank = Rank.age
sandbian.olderBound = 458.4
sandbian.youngerBound = 453.0
sandbian.color = Color.decode '#8DCFAE'
sandbian.names = [:]
sandbian.names << [(Locale.ENGLISH): 'Sandbian']
sandbian.names << [(Locale.GERMAN): 'Sandbium']
sandbian.broader = middle
middle.narrower << sandbian

def katian = ((EpochEntityFactory)(epochEntityFactory)).create()
katian.preferred = 'Katian'
katian.rank = Rank.age
katian.olderBound = 453.0
katian.youngerBound = 445.2
katian.color = Color.decode '#99D4C0'
katian.names = [:]
katian.names << [(Locale.ENGLISH): 'Katian']
katian.names << [(Locale.GERMAN): 'Katium']
katian.broader = middle
middle.narrower << katian

def hirnantian = ((EpochEntityFactory)(epochEntityFactory)).create()
hirnantian.preferred = 'Hirnantian'
hirnantian.rank = Rank.age
hirnantian.olderBound = 445.2
hirnantian.youngerBound = 443.8
hirnantian.color = Color.decode '#A7D8C0'
hirnantian.names = [:]
hirnantian.names << [(Locale.ENGLISH): 'Hirnantian']
hirnantian.names << [(Locale.GERMAN): 'Hirnantium']
hirnantian.broader = middle
middle.narrower << hirnantian

// Silurian -> Paleozoic -> Phanerozoic

def silurian = ((EpochEntityFactory)(epochEntityFactory)).create()
silurian.preferred = 'Silurian'
silurian.rank = Rank.period
silurian.olderBound = 443.8
silurian.youngerBound = 419.2
silurian.color = Color.decode '#A5D6CF'
silurian.names = [:]
silurian.names << [(Locale.ENGLISH): 'Silurian']
silurian.names << [(Locale.GERMAN): 'Silur']
silurian.broader = paleozoic
silurian.narrower = []
paleozoic.narrower << silurian

// Llandovery -> Silurian -> Paleozoic -> Phanerozoic

def llandovery = ((EpochEntityFactory)(epochEntityFactory)).create()
llandovery.preferred = 'Llandovery'
llandovery.rank = Rank.epoch
llandovery.olderBound = 443.8
llandovery.youngerBound = 433.4
llandovery.color = Color.decode '#97D5C9'
llandovery.names = [:]
llandovery.names << [(Locale.ENGLISH): 'Llandovery']
llandovery.names << [(Locale.GERMAN): 'Llandovery']
llandovery.broader = silurian
llandovery.narrower = []
silurian.narrower << llandovery

def rhuddanian = ((EpochEntityFactory)(epochEntityFactory)).create()
rhuddanian.preferred = 'Rhuddanian'
rhuddanian.rank = Rank.age
rhuddanian.olderBound = 443.8
rhuddanian.youngerBound = 440.8
rhuddanian.color = Color.decode '#A5D9C9'
rhuddanian.names = [:]
rhuddanian.names << [(Locale.ENGLISH): 'Rhuddanian']
rhuddanian.names << [(Locale.GERMAN): 'Rhuddanium']
rhuddanian.broader = llandovery
llandovery.narrower << rhuddanian

def aeronian = ((EpochEntityFactory)(epochEntityFactory)).create()
aeronian.preferred = 'Aeronian'
aeronian.rank = Rank.age
aeronian.olderBound = 440.8
aeronian.youngerBound = 438.5
aeronian.color = Color.decode '#B2DED3'
aeronian.names = [:]
aeronian.names << [(Locale.ENGLISH): 'Aeronian']
aeronian.names << [(Locale.GERMAN): 'Aeronium']
aeronian.broader = llandovery
llandovery.narrower << aeronian

def telychian = ((EpochEntityFactory)(epochEntityFactory)).create()
telychian.preferred = 'Telychian'
telychian.rank = Rank.age
telychian.olderBound = 438.5
telychian.youngerBound = 433.4
telychian.color = Color.decode '#BDE3DC'
telychian.names = [:]
telychian.names << [(Locale.ENGLISH): 'Telychian']
telychian.names << [(Locale.GERMAN): 'Telychium']
telychian.broader = llandovery
llandovery.narrower << telychian

// Wenlock -> Silurian -> Paleozoic -> Phanerozoic

def wenlock = ((EpochEntityFactory)(epochEntityFactory)).create()
wenlock.preferred = 'Wenlock'
wenlock.rank = Rank.epoch
wenlock.olderBound = 433.4
wenlock.youngerBound = 427.4
wenlock.color = Color.decode '#B2DED3'
wenlock.names = [:]
wenlock.names << [(Locale.ENGLISH): 'Wenlock']
wenlock.names << [(Locale.GERMAN): 'Wenlock']
wenlock.broader = silurian
wenlock.narrower = []
silurian.narrower << wenlock

def sheinwoodian = ((EpochEntityFactory)(epochEntityFactory)).create()
sheinwoodian.preferred = 'Sheinwoodian'
sheinwoodian.rank = Rank.age
sheinwoodian.olderBound = 433.4
sheinwoodian.youngerBound = 430.5
sheinwoodian.color = Color.decode '#A5D9C9'
sheinwoodian.names = [:]
sheinwoodian.names << [(Locale.ENGLISH): 'Sheinwoodian']
sheinwoodian.names << [(Locale.GERMAN): 'Sheinwoodium']
sheinwoodian.broader = wenlock
wenlock.narrower << sheinwoodian

def homerian = ((EpochEntityFactory)(epochEntityFactory)).create()
homerian.preferred = 'Homerian'
homerian.rank = Rank.age
homerian.olderBound = 430.5
homerian.youngerBound = 427.4
homerian.color = Color.decode '#CBE8DD'
homerian.names = [:]
homerian.names << [(Locale.ENGLISH): 'Homerian']
homerian.names << [(Locale.GERMAN): 'Homerium']
homerian.broader = wenlock
wenlock.narrower << homerian

// Ludlow -> Silurian -> Paleozoic -> Phanerozoic

def ludlow = ((EpochEntityFactory)(epochEntityFactory)).create()
ludlow.preferred = 'Ludlow'
ludlow.rank = Rank.epoch
ludlow.olderBound = 427.4
ludlow.youngerBound = 423
ludlow.color = Color.decode '#BDE3DC'
ludlow.names = [:]
ludlow.names << [(Locale.ENGLISH): 'Ludlow']
ludlow.names << [(Locale.GERMAN): 'Ludlow']
ludlow.broader = silurian
ludlow.narrower = []
silurian.narrower << ludlow

def gorstian = ((EpochEntityFactory)(epochEntityFactory)).create()
gorstian.preferred = 'Gorstian'
gorstian.rank = Rank.age
gorstian.olderBound = 427.4
gorstian.youngerBound = 425.6
gorstian.color = Color.decode '#C9E9E6'
gorstian.names = [:]
gorstian.names << [(Locale.ENGLISH): 'Gorstian']
gorstian.names << [(Locale.GERMAN): 'Gorstium']
gorstian.broader = ludlow
ludlow.narrower << gorstian

def ludfordian = ((EpochEntityFactory)(epochEntityFactory)).create()
ludfordian.preferred = 'Ludfordian'
ludfordian.rank = Rank.age
ludfordian.olderBound = 425.6
ludfordian.youngerBound = 423.0
ludfordian.color = Color.decode '#D7EDE7'
ludfordian.names = [:]
ludfordian.names << [(Locale.ENGLISH): 'Ludfordian']
ludfordian.names << [(Locale.GERMAN): 'Ludfordium']
ludfordian.broader = ludlow
ludlow.narrower << ludfordian

// Pridoli -> Silurian -> Paleozoic -> Phanerozoic

def pridoli = ((EpochEntityFactory)(epochEntityFactory)).create()
pridoli.preferred = 'Pridoli'
pridoli.rank = Rank.epoch
pridoli.olderBound = 423
pridoli.youngerBound = 419.2
pridoli.color = Color.decode '#E4F2E7'
pridoli.names = [:]
pridoli.names << [(Locale.ENGLISH): 'Pridoli']
pridoli.names << [(Locale.GERMAN): 'Pridolium']
pridoli.broader = silurian
silurian.narrower << pridoli

// Devonian -> Paleozoic -> Phanerozoic

def devonian = ((EpochEntityFactory)(epochEntityFactory)).create()
devonian.preferred = 'Devonian'
devonian.rank = Rank.period
devonian.olderBound = 419.2
devonian.youngerBound = 358.9
devonian.color = Color.decode '#CF9C5A'
devonian.names = [:]
devonian.names << [(Locale.ENGLISH): 'Devonian']
devonian.names << [(Locale.GERMAN): 'Devon']
devonian.broader = paleozoic
devonian.narrower = []
paleozoic.narrower << devonian

// Lower -> Devonian -> Paleozoic -> Phanerozoic

def lower_devonian = ((EpochEntityFactory)(epochEntityFactory)).create()
lower_devonian.preferred = 'Lower Devonian'
lower_devonian.rank = Rank.epoch
lower_devonian.olderBound = 419.2
lower_devonian.youngerBound = 393.3
lower_devonian.color = Color.decode '#E5B46E'
lower_devonian.names = [:]
lower_devonian.names << [(Locale.ENGLISH): 'Lower Devonian']
lower_devonian.names << [(Locale.GERMAN): 'Unterdevon']
lower_devonian.broader = devonian
lower_devonian.narrower = []
devonian.narrower << lower_devonian

// Lochkovian -> Lower -> Devonian -> Paleozoic -> Phanerozoic

def lochkovian = ((EpochEntityFactory)(epochEntityFactory)).create()
lochkovian.preferred = 'Lochkovian'
lochkovian.rank = Rank.age
lochkovian.olderBound = 419.2
lochkovian.youngerBound = 410.8
lochkovian.color = Color.decode '#E6BD79'
lochkovian.names = [:]
lochkovian.names << [(Locale.ENGLISH): 'Lochkovian']
lochkovian.names << [(Locale.GERMAN): 'Lochkovium']
lochkovian.broader = lower_devonian
lower_devonian.narrower << lochkovian

// Pragian -> Lower -> Devonian -> Paleozoic -> Phanerozoic

def pragian = ((EpochEntityFactory)(epochEntityFactory)).create()
pragian.preferred = 'Pragian'
pragian.rank = Rank.age
pragian.olderBound = 410.8
pragian.youngerBound = 407.6
pragian.color = Color.decode '#E6C785'
pragian.names = [:]
pragian.names << [(Locale.ENGLISH): 'Pragian']
pragian.names << [(Locale.GERMAN): 'Pragium']
pragian.broader = lower_devonian
lower_devonian.narrower << pragian

// Emsian -> Lower -> Devonian -> Paleozoic -> Phanerozoic

def emsian = ((EpochEntityFactory)(epochEntityFactory)).create()
emsian.preferred = 'Emsian'
emsian.rank = Rank.age
emsian.olderBound = 407.6
emsian.youngerBound = 393.3
emsian.color = Color.decode '#E7D091'
emsian.names = [:]
emsian.names << [(Locale.ENGLISH): 'Emsian']
emsian.names << [(Locale.GERMAN): 'Emsium']
emsian.broader = lower_devonian
lower_devonian.narrower << emsian

// Middle -> Devonian -> Paleozoic -> Phanerozoic

def middle_devonian = ((EpochEntityFactory)(epochEntityFactory)).create()
middle_devonian.preferred = 'Middle Devonian'
middle_devonian.rank = Rank.epoch
middle_devonian.olderBound = 393.3
middle_devonian.youngerBound = 382.7
middle_devonian.color = Color.decode '#F1CA84'
middle_devonian.names = [:]
middle_devonian.names << [(Locale.ENGLISH): 'Middle Devonian']
middle_devonian.names << [(Locale.GERMAN): 'Mitteldevon']
middle_devonian.broader = devonian
devonian.narrower << middle_devonian

// Upper -> Devonian -> Paleozoic -> Phanerozoic

def upper_devonian = ((EpochEntityFactory)(epochEntityFactory)).create()
upper_devonian.preferred = 'Upper Devonian'
upper_devonian.rank = Rank.epoch
upper_devonian.olderBound = 382.7
upper_devonian.youngerBound = 358.9
upper_devonian.color = Color.decode '#F1DFAF'
upper_devonian.names = [:]
upper_devonian.names << [(Locale.ENGLISH): 'Upper Devonian']
upper_devonian.names << [(Locale.GERMAN): 'Oberdevon']
upper_devonian.broader = devonian
devonian.narrower << upper_devonian

[precambrian, phanerozoic]
