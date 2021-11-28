package com.canonal.jetpacknavigation.fragment

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.canonal.jetpacknavigation.R
import com.canonal.jetpacknavigation.databinding.FragmentDeepLinkBinding


class DeepLinkFragment : Fragment() {

    private lateinit var binding: FragmentDeepLinkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDeepLinkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.tvText.text = arguments?.getString("myKey")
        binding.btnSendNotification.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("myKey", binding.etText.text.toString())

            val deepLinkFromNotification = findNavController().createDeepLink()
                .setDestination(R.id.deepLinkFragment)
                .setArguments(bundle)
                .createPendingIntent()

            val notificationManager =
                context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(
                    NotificationChannel(
                        "deepLink",
                        "Deep Links",
                        NotificationManager.IMPORTANCE_HIGH
                    )
                )
            }
            val builder = NotificationCompat.Builder(
                requireContext(), "deepLink"
            )
                .setContentTitle("Notification Title")
                .setContentText(binding.etText.text)
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(deepLinkFromNotification)
                .setAutoCancel(true)
            notificationManager.notify(0, builder.build())
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            DeepLinkFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}