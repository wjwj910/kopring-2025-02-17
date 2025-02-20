"use client";

import { Button } from "@/components/ui/button";

import { LogIn } from "lucide-react";

export default function LoginButton({
  variant,
  className,
  text,
  icon,
  providerTypeCode = "kakao",
}: {
  variant?:
    | "link"
    | "default"
    | "destructive"
    | "outline"
    | "secondary"
    | "ghost"
    | null
    | undefined;
  className?: string;
  text?: string | boolean;
  icon?: React.ReactNode;
  providerTypeCode?: string;
}) {
  const socialLoginForKakaoUrl = `http://localhost:8080/oauth2/authorization/${providerTypeCode}`;
  const redirectUrlAfterSocialLogin = "http://localhost:3000";
  if (!variant) variant = "link";
  if (typeof text === "boolean") text = "로그인";

  return (
    <Button variant={variant} className={className} asChild>
      <a
        href={`${socialLoginForKakaoUrl}?redirectUrl=${redirectUrlAfterSocialLogin}`}
      >
        {icon || <LogIn />}
        {text && <span>{text}</span>}
      </a>
    </Button>
  );
}