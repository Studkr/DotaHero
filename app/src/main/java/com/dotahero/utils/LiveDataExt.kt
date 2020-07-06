package pro.shineapp.rentout.system.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
//import kotlinx.coroutines.flow.MutableStateFlow

fun <T : Any, L : LiveData<T>> AppCompatActivity.observe(liveData: L, body: (T) -> Unit) {
    liveData.observe(this, Observer(body))
}

fun <T : Any, L : LiveData<T>> Fragment.observe(liveData: L, body: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner, Observer(body))
}


fun <T> LiveData<T>.toSingleLiveEvent(): LiveEvent<T> {
    val liveData = LiveEvent<T>()
    liveData.addSource(this) { value ->
        liveData.value = value
    }
    return liveData
}

//fun MutableStateFlow<Throwable?>.toErrorLiveEvent(): LiveEvent<Throwable> {
//    return distinctUntilChanged { old, new ->
//        if (old != null && new != null) {
//            old::class == new::class
//        } else {
//            old == new
//        }
//    }.filterNotNull().asLiveData().toSingleLiveEvent()
//}