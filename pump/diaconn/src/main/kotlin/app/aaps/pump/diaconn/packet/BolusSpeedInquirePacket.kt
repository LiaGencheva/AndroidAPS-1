package app.aaps.pump.diaconn.packet

import app.aaps.core.interfaces.logging.LTag
import dagger.android.HasAndroidInjector
import app.aaps.pump.diaconn.DiaconnG8Pump
import javax.inject.Inject

/**
 * BolusSpeedInquirePacket
 */
class BolusSpeedInquirePacket(injector: HasAndroidInjector) : DiaconnG8Packet(injector) {

    @Inject lateinit var diaconnG8Pump: DiaconnG8Pump

    init {
        msgType = 0x45.toByte()
        aapsLogger.debug(LTag.PUMPCOMM, "BolusSpeedInquirePacket init ")
    }

    override fun encode(msgSeq: Int): ByteArray {
        return suffixEncode(prefixEncode(msgType, msgSeq, MSG_CON_END))
    }

    override val friendlyName = "PUMP_BOLUS_SPEED_INQUIRE"
}